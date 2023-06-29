package com.example.demo.controller;

import com.example.demo.security.IsAdmin;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    //ai cũng vào được.
    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    // có role admin hoặc author mới có thể vào
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    // có role admin mới vào được.
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @IsAdmin
    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }


    // có role author mới vào được
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/author")
    public String getBlog() {
        return "author";
    }

}
