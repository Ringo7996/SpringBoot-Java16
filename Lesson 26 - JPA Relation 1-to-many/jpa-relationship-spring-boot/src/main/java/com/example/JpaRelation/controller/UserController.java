package com.example.JpaRelation.controller;

import com.example.JpaRelation.entity.FileServer;
import com.example.JpaRelation.entity.User;
import com.example.JpaRelation.service.FileServerService;
import com.example.JpaRelation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FileServerService fileServerService;

    @GetMapping("")
    public ResponseEntity<?> getUsers(Model model) {
        List<User> userList = userService.getAllUsers();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}/files")
    public ResponseEntity<?> getFiles(@PathVariable(name = "id") Integer id, Model model) {
        List<FileServer> fileServerList = fileServerService.getFilesOfUser(id);

        model.addAttribute("fileServerList", fileServerList);
//        return ResponseEntity.ok(fileServerList);
        return ResponseEntity.ok(fileServerList);
    }

    // 1. Upload file
    @PostMapping("{id}/files")
    public ResponseEntity<?> uploadFile(@PathVariable Integer id, @ModelAttribute("file") MultipartFile file) {
        return ResponseEntity.ok(fileServerService.uploadFileByUserId(id, file));
    }

}
