package com.example.usermanagement.controller;

import com.example.usermanagement.dto.FileResponse;
import com.example.usermanagement.service.FileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("api/v1")
public class FileController {
    private FileService fileService;
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    // 1. Upload file

    @GetMapping(value = "files/{id}")
    public ResponseEntity<?> readFile(@PathVariable String id) {
        byte[] bytes = fileService.readFile
                (id)
                ;
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    // 2. Xem thông tin file
    @PostMapping("files")
    public ResponseEntity<?> uploadFile(@ModelAttribute("file") MultipartFile file) {
        FileResponse fileResponse = fileService.uploadFile(file);
        return ResponseEntity.ok(fileResponse);
    }
}