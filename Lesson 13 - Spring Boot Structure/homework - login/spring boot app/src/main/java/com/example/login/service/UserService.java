package com.example.login.service;

import com.example.login.dto.UserRecord;
import com.example.login.entity.User;
import com.example.login.error.NotFoundException;
import com.example.login.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements LoginService {
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "mongmo", "mongmo@gmail.com", "0987654321", "avatar.img", "123"));
        users.add(new User(2, "nhulac", "laclac@gmail.com", "0123456789", "avatar1.img", "123"));
        users.add(new User(3, "longleo", "longleo@gmail.com", "0987564664", "avatar3.img", "123"));
        users.add(new User(4, "thiteo", "teo@gmail.com", "0874845455", "avatar9.img", "123"));
    }

    @Override
    public UserRecord loginService(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return UserMapper.toUserRecord(user);
            }
        }

        throw new NotFoundException("Username hoặc password chưa chính xác");
    }
}
