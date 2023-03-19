package com.pl.test.controller;

import com.pl.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService dbUserService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users",
                dbUserService.getAllUsers());
        return "users.html";
    }

    @GetMapping("/")
    public String main() {
        return "index.html";
    }
}
