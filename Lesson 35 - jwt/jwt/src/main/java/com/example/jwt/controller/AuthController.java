package com.example.jwt.controller;

import com.example.jwt.repository.UserRepository;
import com.example.jwt.request.LoginRequest;
import com.example.jwt.security.CustomUserDetailsService;
import com.example.jwt.security.JwtUtils;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;


    @PostMapping("/login-handle")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        // Tạo đối tượng xác thực
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );

        try {
            // Tiến hành xác thực
            Authentication authentication = authenticationManager.authenticate(token);

            // Lưu dữ liệu vào context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // TODO: Lấy ra thông tin của user
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(authentication.getName());

            // TODO : Tạo ra token và trả về cho client
            String jwtToken = jwtUtils.generateToken(userDetails);

            return ResponseEntity.ok(jwtToken);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
