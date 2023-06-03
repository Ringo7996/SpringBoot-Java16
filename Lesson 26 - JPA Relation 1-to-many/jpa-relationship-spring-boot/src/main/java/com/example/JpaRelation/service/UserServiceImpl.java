package com.example.JpaRelation.service;

import com.example.JpaRelation.entity.FileServer;
import com.example.JpaRelation.entity.User;
import com.example.JpaRelation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
