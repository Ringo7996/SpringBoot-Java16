package com.example.userdemo.controller;

import com.example.userdemo.dto.UserRecord;
import com.example.userdemo.error.ErrorResponse;
import com.example.userdemo.error.NotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.userdemo.service.UserService;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserRecord user = userService.getUserById(id);
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "name", required = true) String name){
        List<UserRecord> users = userService.searchUser(name);
        System.out.println("ist"+ users);
        return  ResponseEntity.ok(users);
    }


    @PostMapping("")
    public ResponseEntity<?> createUser() {

        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser() {
        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser() {
        return null;
    }




}
