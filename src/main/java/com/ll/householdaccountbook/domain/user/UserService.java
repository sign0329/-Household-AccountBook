package com.ll.householdaccountbook.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User create(String email, String name){
        User user = User.builder()
                .email(email)
                .name(name)
                .build();

        return userRepository.save(user);
    }
}
