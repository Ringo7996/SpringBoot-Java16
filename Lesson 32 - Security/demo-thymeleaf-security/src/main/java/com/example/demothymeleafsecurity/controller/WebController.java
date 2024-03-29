package com.example.demothymeleafsecurity.controller;

import com.example.demothymeleafsecurity.security.AuthenticationFacade;
import com.example.demothymeleafsecurity.security.IsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
public class WebController {

    //ai cũng vào được.
    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/login-process")
    public String getLoginPage() {
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
