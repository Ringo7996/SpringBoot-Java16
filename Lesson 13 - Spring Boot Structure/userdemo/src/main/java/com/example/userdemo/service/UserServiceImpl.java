package com.example.userdemo.service;

import com.example.userdemo.dto.CreateUserRequest;
import com.example.userdemo.dto.UserRecord;
import com.example.userdemo.entity.User;
import com.example.userdemo.error.UserNotFoundExeption;
import com.example.userdemo.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com", "0987654321", "avatar.img", "123"));
        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com", "0123456789", "avatar1.img", "123"));
        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com", "0987564664", "avatar3.img", "123"));
        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com", "0874845455", "avatar9.img", "123"));
    }

    @Override
    public ArrayList<UserRecord> getUserList() {
        return (ArrayList<UserRecord>) users.stream().map(UserMapper::toUserRecord).collect(Collectors.toList());
    }

    @Override
    public UserRecord getUserById(int id) {
//        Optional<User> user2Find =  users.stream().filter(user -> user.getId() == id).findFirst();
//        if (user2Find.isPresent()){
//            return UserMapper.toUserRecord(user2Find.get());
//        } else {
//            return null;
//        }

        Optional<User> user2Find  = users.stream().filter(user -> user.getId() == id).findFirst();
        if (!user2Find.isPresent()) {
            throw new UserNotFoundExeption("User" + id + "not found");
        } else {
            return UserMapper.toUserRecord(user2Find.get());
        }

//        for (User user : users) {
//            if (user.getId() == id){
//                return user;
//            }
//        }

    }



    @Override
    public List<UserRecord> searchUser(String name) {
        return users.stream().filter(user -> user.getName().contains(name)).map(UserMapper::toUserRecord).collect(Collectors.toList());
    }

    @Override
    public List<UserRecord> searchUser(List<String> names) {
        return users.stream().filter(user -> checkUsernameContain(names,user.getName())).map(UserMapper::toUserRecord).collect(Collectors.toList());

    }

    private boolean checkUsernameContain(List<String> names, String username) {
        return names.stream().filter(e -> username.contains(e)).findFirst().isPresent();
    }



    @Override
    public UserRecord createUser(CreateUserRequest request) {
        User newUser = User.builder().withId(users.size()+1)
                .withName(request.getFullName())
                .withEmail(request.getEmail())
                .withPhone(request.getPhone())
              .withPassword(request.getPassword())
//                .withPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)))
                .build();


        return UserMapper.toUserRecord(newUser);

    }
}
