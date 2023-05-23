package com.example.practiceJPA.repository;

import com.example.practiceJPA.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Dish, Integer> {

    @Query(nativeQuery = true, value = "select sum(price) from dish")
    Double getPriceOfAllDishes();
}
