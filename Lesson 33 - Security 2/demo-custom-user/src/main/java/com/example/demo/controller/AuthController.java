package com.example.demo.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.request.LoginRequest;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        //Tạo đối tượng xác thực
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );

        // tiến hành xác thực
        try {
            Authentication authentication = authenticationManager.authenticate(token);

            // lưu vào context holder
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // lưu vào trong session
            session.setAttribute("MY_SESSION",authentication.getPrincipal());   // lưu email vào session

           return ResponseEntity.ok("Login successfully");
        }catch (Exception e) {
           return ResponseEntity.badRequest().body("Login failed");
        }
    }
}

//Client gửi request đến sever -> xác thực thành công tạo ra session -> lưu session id vào cookie
// cookie gửi về cho client. Các requets tiếp theo sẽ gửi kèm cookie (chứa session id) lên