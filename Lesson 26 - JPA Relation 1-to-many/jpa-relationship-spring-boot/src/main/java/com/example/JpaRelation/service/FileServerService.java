package com.example.JpaRelation.service;

import com.example.JpaRelation.entity.FileServer;
import com.example.JpaRelation.response.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileServerService {
    List<FileServer> getFileById(Integer id);
    List<FileServer> getFilesOfUser(Integer id);

    void deleteFileById(Integer id);

    FileServer readFileById(Integer id);


    FileServer uploadFileByUserId(Integer id, MultipartFile file);
}
