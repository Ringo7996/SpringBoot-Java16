package com.example.JpaRelation.service;

import com.example.JpaRelation.entity.FileServer;
import com.example.JpaRelation.entity.User;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();


}
