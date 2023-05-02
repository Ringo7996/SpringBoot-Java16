package vn.techmaster.usermanagement.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.usermanagement.dto.CreateUserRequest;
import vn.techmaster.usermanagement.dto.UpdateUserPasswordRequest;
import vn.techmaster.usermanagement.dto.UpdateUserRequest;
import vn.techmaster.usermanagement.dto.UserDTO;
import vn.techmaster.usermanagement.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        List<UserDTO> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTO userById = userService.getUserById(id);
        return ResponseEntity.ok(userById);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getUserByNameContain(@RequestParam(name = "name") String name) {
        List<UserDTO> userByNameContain = userService.getUserByNameContain(name);
        return ResponseEntity.ok(userByNameContain);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserDTO createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @Valid @RequestBody UpdateUserRequest request) {
        UserDTO updatedUser = userService.updateUser(id, request);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}/updatePassword")
    public ResponseEntity<?> updateUserPassword(@PathVariable int id, @Valid @RequestBody UpdateUserPasswordRequest request) {
        UserDTO pwUpdatedUser = userService.updateUserPassWord(id, request);
        return ResponseEntity.ok(pwUpdatedUser);
    }
}
