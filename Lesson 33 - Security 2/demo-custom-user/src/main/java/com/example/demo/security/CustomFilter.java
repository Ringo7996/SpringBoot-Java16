package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Kiểm tra quyền của user đối với mỗi request
@Component
@Slf4j
public class CustomFilter extends OncePerRequestFilter {
    @Autowired
    private CustomUserDetailService customUserDetailService;


    @Override
    // lấy ra email trong session
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userEmail = (String) request.getSession().getAttribute("MY_SESSION");
        if (userEmail == null) {
            filterChain.doFilter(request, response);
        }

        // lấy ra thông tin của user
//        UserDetails userDetails = customUserDetailService
    }
}