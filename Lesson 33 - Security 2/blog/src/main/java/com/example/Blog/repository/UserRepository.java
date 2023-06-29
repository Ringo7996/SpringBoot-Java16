package com.example.Blog.repository;

import com.example.Blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoles_NameIn(List<String> roles);

    Optional<User> findByEmail(String email);
}