package com.example.ss10.controller;

import com.example.ss10.model.Account;
import com.example.ss10.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("bai3")
    public String showForm(Model model) {
        model.addAttribute("account", new Account());
        return "registerForm";
    }

    @PostMapping("addAccount")
    public String addAccount(@ModelAttribute("account") Account account, Model model) {
        boolean result = accountService.createAccount(account);
        if (result) {
            model.addAttribute("message", "Tạo tài khoản thành công!");
        } else {
            model.addAttribute("message", "Tạo tài khoản thất bại. Vui lòng thử lại.");
        }
        return "registerForm";
    }
}
