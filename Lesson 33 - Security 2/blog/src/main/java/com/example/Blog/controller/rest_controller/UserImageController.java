package com.example.Blog.controller.rest_controller;


import com.example.Blog.entity.Image;
import com.example.Blog.entity.User;
import com.example.Blog.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserImageController {
    @Autowired
    private ImageService imageService;

    // upload ảnh
    @PostMapping("/files")
    public Image uploadImage(@ModelAttribute("file") MultipartFile file) {
        // upload len user id 1;
        return imageService.uploadImageByUserId(1, file);
    }


    // xem ảnh
    @GetMapping("/files/{id}")
    public ResponseEntity<?> readImage(@PathVariable Integer id) {
        Image image = imageService.readImageById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(image.getData());
    }


    @GetMapping("/users/{id}/files")
    public List<Image> getImageListByUserId(@PathVariable Integer id) {
        return imageService.getImageListByUserId(id);

    }


    // 3. xoá ảnh
    @DeleteMapping("/files/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable(name = "id") Integer Fileid) {
        // đang đăng nhập user id 1;
        imageService.deleteImageById(Fileid, 1);
        return ResponseEntity.noContent().build();
    }

}
