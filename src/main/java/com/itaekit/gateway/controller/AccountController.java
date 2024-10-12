package com.itaekit.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountController {
    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signupForm";
    }

    @GetMapping("/user/{userId}")
    public String mypage(@PathVariable String userId) {
        return "mypage";
    }
}
