package com.example.usermanagement.service;

import com.example.usermanagement.dto.CreateUserRequest;
import com.example.usermanagement.dto.UpdatePasswordRequest;
import com.example.usermanagement.dto.UpdateUserRequest;
import com.example.usermanagement.dto.UserRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserRecord> getUserList();

    UserRecord getUserById(int id);

    List<UserRecord> searchUser(String name);
    UserRecord createUser(CreateUserRequest request);


    List<UserRecord> deleteUser(String id);

    UserRecord updateUser(int id, UpdateUserRequest req);

    UserRecord updatePassword(int id, UpdatePasswordRequest req);
}
