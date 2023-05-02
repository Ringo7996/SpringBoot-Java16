package com.example.userdemo.controller;

import com.example.userdemo.dto.CreateUserRequest;
import com.example.userdemo.dto.UserRecord;
import com.example.userdemo.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.userdemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserRecord userRecord = userService.getUserById(id);
//        if (userRecord == null) {
//            return ResponseEntity.notFound().build();
//        }

        return ResponseEntity.ok(userRecord);
    }

//    @GetMapping("search")
//    public ResponseEntity<?> searchUser(@RequestParam(name = "name", required = true) String name) {
//        List<UserRecord> users = userService.searchUser(name);
//
//        return ResponseEntity.ok(users);
//    }

    @GetMapping("search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "names", required = true) List<String> names) {
        List<UserRecord> users = userService.searchUser(names);

        return ResponseEntity.ok(users);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser() {
        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser() {
        return null;
    }


//    @ExceptionHandler(UserNotFoundExeption.class)
//    public ErrorResponse handlerNotFoundExcepton(UserNotFoundExeption ex, WebRequest reg) {
//
//        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
//    }





}
