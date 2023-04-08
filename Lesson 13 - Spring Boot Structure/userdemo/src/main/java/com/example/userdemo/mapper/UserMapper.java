package com.example.userdemo.mapper;

import com.example.userdemo.dto.UserRecord;
import com.example.userdemo.entity.User;

public class UserMapper {
    public static UserRecord toUserRecord(User user) {
        return new UserRecord(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getAvatar());

    }

}
