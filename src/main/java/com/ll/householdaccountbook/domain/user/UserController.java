package com.ll.householdaccountbook.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public Long create(){
        User user = userService.create("test@test.com", "테스트 유저");
        return user.getId();
    }
}
