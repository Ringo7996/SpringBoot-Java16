package com.example.JpaRelation.service;

import com.example.JpaRelation.entity.FileServer;
import com.example.JpaRelation.entity.User;
import com.example.JpaRelation.repository.FileServerRepository;
import com.example.JpaRelation.repository.UserRepository;
import com.example.JpaRelation.response.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileServerServiceImpl implements FileServerService {
    @Autowired
    private FileServerRepository fileServerRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<FileServer> getFilesOfUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found user");
                });
        return fileServerRepository.findByUser_Id(id);
    }

    @Override
    public List<FileServer> getFileById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found user");
                });
        return fileServerRepository.findByUser_Id(id);

    }

    @Override
    public void deleteFileById(Integer id) {
        FileServer fileServer = fileServerRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found file");
                });
        fileServerRepository.delete(fileServer);
    }

    @Override
    public FileServer readFileById(Integer id) {
        FileServer fileServer = fileServerRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found file");
                });
        return fileServer;
    }

    @Override
    public FileServer uploadFileByUserId(Integer userId, MultipartFile file) {
        validateFile(file);
        // validate file: ktra ten file, dinh dang file co cho phep ko, size
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });

        try {
            FileServer fileServer = FileServer.builder()
                    .type(file.getContentType())
                    .data(file.getBytes())
                    .user(user)
                    .build();

            fileServerRepository.save(fileServer);

            return fileServer;
        } catch (IOException e) {
            throw new RuntimeException("Loi upload file");
        }
    }

    private void validateFile(MultipartFile file) {
        // Validate file :
        // - Tên file
        // - Định dạng file có cho phép hay không
        // - Kiểm tra kích thước file
    }
}
