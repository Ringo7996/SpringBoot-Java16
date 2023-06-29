package com.example.demo.service;

import com.example.demo.model.TokenConfirm;
import com.example.demo.model.User;
import com.example.demo.repository.TokenConfirmRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenConfirmRepository tokenConfirmRepository;

    @Autowired
    private MailService mailService;


    @Override
    public void sendResetPwEmail(String email) {
        // tra email co ton tai trong database ko.
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        TokenConfirm token = TokenConfirm.builder()
                .user(user)
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusMinutes(10))
                .token(UUID.randomUUID().toString())
                .build();

        // tao ra token -> luu vao co so du lieu
        tokenConfirmRepository.save(token);

        // send email chua token
        // link: http://localhost:8080/reset-password/{token}
        String resetPwURL = "http://localhost:8080/reset-password/" + token.getToken();

        mailService.sendMail(
                user.getEmail(),
                "Reset Password",
                "Click this link to reset password " + resetPwURL
        );
    }

    @Override
    public void resetPw(String email, String encodedPassword) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}
