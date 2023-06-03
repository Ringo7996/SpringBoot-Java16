package com.example.JpaRelation.repository;

import com.example.JpaRelation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

// trang  1: danh sách user
//trang 2: liệt kê các file trong user đó + chức năng xem, thêm, xoá file