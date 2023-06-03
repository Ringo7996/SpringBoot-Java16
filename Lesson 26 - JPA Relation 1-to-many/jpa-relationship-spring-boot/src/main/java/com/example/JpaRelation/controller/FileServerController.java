package com.example.JpaRelation.controller;

import com.example.JpaRelation.entity.FileServer;
import com.example.JpaRelation.service.FileServerService;
import com.example.JpaRelation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/files")
public class FileServerController {
    @Autowired
    private FileServerService fileServerService;

    // 2. Xem file
    @GetMapping("{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id) {
        FileServer fileServer = fileServerService.readFileById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileServer.getType()))
                .body(fileServer.getData());
    }

    // 3. Xoa file
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        fileServerService.deleteFileById(id);
        return ResponseEntity.noContent().build();
    }


}
