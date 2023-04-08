package com.example.userdemo.service;

import com.example.userdemo.dto.UserRecord;
import com.example.userdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    ArrayList<UserRecord> getUserList();

    UserRecord getUserById(int id);

    List<UserRecord> searchUser(String name);

    List<UserRecord> searchUser(List<String> name);
}
