package com.example.demothymeleafsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    //ai cũng vào được.
    @GetMapping("/")
    public String getHome() {
        return "Home page";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SALE')")
    @GetMapping("/dashboad")
    public String getDashboad() {
        return "Dashboard";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/user-management")
    public String getUserManagement() {
        return "User management page";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SALE')")
    @GetMapping("/product-management")
    public String getProductManagement() {
        return "Product management page";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR') or hasRole('ROLE_SALE')")
    @GetMapping("/blog-management")
    public String getBlogManagement() {
        return "Blog management page";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user-info")
    public String getUserInfo() {
        return "User Information page";
    }

}
