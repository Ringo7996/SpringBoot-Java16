package com.example.login.mapper;

import com.example.login.dto.UserRecord;
import com.example.login.entity.User;

public class UserMapper {
    public static UserRecord toUserRecord(User user) {
        return new UserRecord(user.getId(), user.getUsername(), user.getEmail(), user.getPhone(), user.getAvatar());

    }

}
