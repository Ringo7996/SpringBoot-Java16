package com.example.JpaRelation.repository;

import com.example.JpaRelation.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}