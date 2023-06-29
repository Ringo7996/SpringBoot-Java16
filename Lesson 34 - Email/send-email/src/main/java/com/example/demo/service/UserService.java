package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    void sendResetPwEmail(String email);

    void resetPw(String email, String encodedPassword);
}
