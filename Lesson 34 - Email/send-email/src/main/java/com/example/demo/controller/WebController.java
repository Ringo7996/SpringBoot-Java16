package com.example.demo.controller;

import com.example.demo.model.TokenConfirm;
import com.example.demo.repository.TokenConfirmRepository;
import com.example.demo.security.IsAdmin;
import com.example.demo.service.MailService;
import com.example.demo.service.TokenConfirmService;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

@Controller
public class WebController {

    @Autowired
    private MailService mailService;

    @Autowired
    private TokenConfirmService tokenConfirmService;

    // Ai cũng có thể vào được
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

    @GetMapping("/forgot-password")
    public String getForgotPasswordPage() {
        return "forgot-password";
    }

    // Có role admin hoặc author mới có thể vào
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    // Phải có role admin mới vào được
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @IsAdmin
    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    // Phải có role author mới vào được
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/author")
    public String getAuthor() {
        return "author";
    }

    // Gửi -> Gửi email xác nhận quên mật khẩu
    // Trong email có 1 link để xác thực
    @GetMapping("/api/send-email")
    public ResponseEntity<?> testSendMail() {
        mailService.sendMail(
                "linh@gmail.com",
                "Tiêu đề nhó",
                "Ko có gì"
        );
        return ResponseEntity.ok("Send mail success");
    }


    @GetMapping("/reset-password/{token}")
    public String getUpdatePasswordPage(@PathVariable String token, Model model) {
        model = tokenConfirmService.checkToken(token, model);
        return "update-password";
    }




}
