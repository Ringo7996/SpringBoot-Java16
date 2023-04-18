package com.example.usermanagement.controller;

import com.example.usermanagement.dto.CreateUserRequest;
import com.example.usermanagement.dto.UpdatePasswordRequest;
import com.example.usermanagement.dto.UpdateUserRequest;
import com.example.usermanagement.dto.UserRecord;
import com.example.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    //Lấy danh sách user
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        return ResponseEntity.ok(userService.getUserList());
    }

    // Lấy thông tin user
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserRecord userRecord = userService.getUserById(id);
        return ResponseEntity.ok(userRecord);
    }


    //Tìm kiếm user
    @GetMapping("search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "name", required = true) String name) {
        List<UserRecord> users = userService.searchUser(name);

        return ResponseEntity.ok(users);
    }

    // Tạo mới user
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest req) {
        return ResponseEntity.ok(userService.createUser(req));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "id", required = true) String id) {
        List<UserRecord> users = userService.deleteUser(id);

        return ResponseEntity.ok(users);
    }


    // Cập nhật thông tin user
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest req ) {
        return ResponseEntity.ok(userService.updateUser(id, req));

    }

    @PutMapping("/{id}/changePassword")
    public ResponseEntity<?> updatePassword(@PathVariable int id, @RequestBody UpdatePasswordRequest req ) {
        return ResponseEntity.ok(userService.updatePassword(id, req));

    }


}
