package com.example.Blog.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class CustomFilter extends OncePerRequestFilter {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    //lấy ra email trong session
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userEmail = (String) request.getSession().getAttribute("MY_SESSION");

        log.info("email = {}", userEmail);
        if (userEmail == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // lấy ra thông tin user
        UserDetails userDetails = customUserDetailService.loadUserByUsername(userEmail);


        //tạo đối tượng phan quyền
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                null,
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request, response);
    }
}
