package com.example.usermanagement.service;

import com.example.usermanagement.dto.FileResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
    FileResponse uploadFile(MultipartFile file);

    byte[] readFile(String id);
}