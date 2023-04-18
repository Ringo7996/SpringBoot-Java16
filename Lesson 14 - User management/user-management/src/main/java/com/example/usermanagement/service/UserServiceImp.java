package com.example.usermanagement.service;

import com.example.usermanagement.dto.CreateUserRequest;
import com.example.usermanagement.dto.UpdatePasswordRequest;
import com.example.usermanagement.dto.UpdateUserRequest;
import com.example.usermanagement.dto.UserRecord;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.exception.NotFoundException;
import com.example.usermanagement.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private static int id = 1;
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(id++, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com", "0987654321", "HN", "avatar.img", "123"));
        users.add(new User(id++, "Bùi Như Lạc", "laclac@gmail.com", "0123456789", "HP", "avatar1.img", "123"));
        users.add(new User(id++, "Phan Thị Lỏng Lẻo", "longleo@gmail.com", "0987564664", "QN", "avatar3.img", "123"));
        users.add(new User(id++, "Bành Thị Tèo", "teo@gmail.com", "0874845455", "HCM", "avatar9.img", "123"));
    }


    @Override
    public List<UserRecord> getUserList() {
        return users.stream().map(UserMapper::toUserRecord).collect(Collectors.toList());
    }


    @Override
    public UserRecord getUserById(int id) {
        Optional<User> user2Find = users.stream().filter(user -> user.getId() == id).findFirst();
        if (!user2Find.isPresent()) {
            throw new NotFoundException("User" + id + "not found");
        } else {
            return UserMapper.toUserRecord(user2Find.get());
        }

    }

    @Override
    public List<UserRecord> searchUser(String name) {
        return users.stream().filter(user -> user.getName().contains(name)).map(UserMapper::toUserRecord).collect(Collectors.toList());
    }

    @Override
    public UserRecord createUser(CreateUserRequest request) {
        User newUser = User.builder().withId(id++)
                .withName(request.getName())
                .withEmail(request.getEmail())
                .withPhone(request.getPhone())
                .withPassword(request.getPassword())
//                .withPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)))
                .withAddress(request.getAddress())
                .build();

        users.add(newUser);

        return UserMapper.toUserRecord(newUser);

    }

    @Override
    public List<UserRecord> deleteUser(String id) {
        User user2Find = null;
        for (User u : users) {
            if (u.getId() == Integer.parseInt(id)){
                user2Find = u;
                break;
            }
        }
        if (user2Find == null) {
            throw new NotFoundException("User" + id + "not found");
        } else {
            users.remove(user2Find);
        }
        return users.stream().map(UserMapper::toUserRecord).collect(Collectors.toList());
    }

    @Override
    public UserRecord updateUser(int id, UpdateUserRequest req) {
        User user2Find = null;
        for (User u : users) {
            if (u.getId() == id){
                user2Find = u;
                break;
            }
        }
        if (user2Find == null) {
            throw new NotFoundException("User" + id + "not found");
        } else {
            user2Find.setName(req.getName());
            user2Find.setEmail(req.getEmail());
            user2Find.setPhone(req.getPhone());
            user2Find.setAddress(req.getAddress());
            user2Find.setAvatar(req.getAvatar());
        }

        return UserMapper.toUserRecord(user2Find);
    }

    @Override
    public UserRecord updatePassword(int id, UpdatePasswordRequest req) {
        User user2Find = null;
        for (User u : users) {
            if (u.getId() == id){
                user2Find = u;
                break;
            }
        }
        if (user2Find == null) {
            throw new NotFoundException("User" + id + "not found");
        }
        if (user2Find.getEmail().equals(req.getEmail())){
            user2Find.setPassword(req.getNewPassword());
        } else {
            throw new NotFoundException("Email của tài khoản không đúng");
        }

        return UserMapper.toUserRecord(user2Find);

    }
}
