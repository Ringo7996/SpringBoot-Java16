package com.example.usermanagement.mapper;

import com.example.usermanagement.dto.UserRecord;
import com.example.usermanagement.entity.User;

public class UserMapper {
    public static UserRecord toUserRecord(User user) {
        return new UserRecord(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getAddress(), user.getAvatar());

    }


}
