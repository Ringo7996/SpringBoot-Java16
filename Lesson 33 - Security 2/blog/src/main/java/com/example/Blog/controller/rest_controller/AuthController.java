package com.example.Blog.controller.rest_controller;

import com.example.Blog.request.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login-handle")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        //tạo đối tượng xác thực
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );


        try {
            Authentication authentication = authenticationManager.authenticate(token);

            // lưu vào context holder
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // lưu vào session
            session.setAttribute("MY_SESSION", authentication.getName());

            return ResponseEntity.ok("Login successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }
}


