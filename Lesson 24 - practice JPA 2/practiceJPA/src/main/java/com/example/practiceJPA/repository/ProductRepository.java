package com.example.practiceJPA.repository;

import com.example.practiceJPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value = "select sum(price * quantity) from product")
    Double getTotalPrice();
}
