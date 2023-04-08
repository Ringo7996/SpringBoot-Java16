package com.example.login.controller;

import com.example.login.dto.UserRecord;
import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public LoginService loginService;

    @GetMapping("")
    public ResponseEntity<?> checkLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserRecord userRecord = loginService.loginService(username,password);

        return ResponseEntity.ok(userRecord);
    }
}
