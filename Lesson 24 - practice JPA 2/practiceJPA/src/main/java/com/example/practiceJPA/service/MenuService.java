package com.example.practiceJPA.service;

import com.example.practiceJPA.entity.Dish;
import com.example.practiceJPA.request.AddDishRequest;

import java.util.List;

public interface MenuService {
    List<Dish> insertDishes(List<AddDishRequest> requests);

    Double getTotalPrice();
}
