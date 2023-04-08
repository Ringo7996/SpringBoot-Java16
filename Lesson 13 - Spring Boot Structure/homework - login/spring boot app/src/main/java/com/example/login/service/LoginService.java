package com.example.login.service;

import com.example.login.dto.UserRecord;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    UserRecord loginService(String username, String password);
}
