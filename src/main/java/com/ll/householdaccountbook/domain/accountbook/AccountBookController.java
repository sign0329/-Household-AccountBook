package com.ll.householdaccountbook.domain.accountbook;

import com.ll.householdaccountbook.domain.accountbook.dto.AccountBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/account-books")
public class AccountBookController {

    private final AccountBookService accountBookService;
    @GetMapping
    public String list(Model model){
        Long userId = 1L;
        model.addAttribute("accountBooks", accountBookService.findAll(userId));
        return "accountbooks";
    }

    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("accountBookRequest", new AccountBookRequest(null, 0, null, null, null));
        return "accountbook-form";
    }
    @PostMapping
    public String create(@ModelAttribute AccountBookRequest request){
        Long userId = 1L;
        accountBookService.save(userId, request);
        return "redirect:/account-books";
    }
}
