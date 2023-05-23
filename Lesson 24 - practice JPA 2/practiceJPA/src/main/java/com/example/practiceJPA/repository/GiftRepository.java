package com.example.practiceJPA.repository;

import com.example.practiceJPA.entity.Customer;
import com.example.practiceJPA.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Integer> {

    @Query(nativeQuery = true, value = "select sum(price) from gift")
    Double getTotalPrice();
}
