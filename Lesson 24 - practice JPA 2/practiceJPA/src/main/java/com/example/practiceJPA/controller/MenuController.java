package com.example.practiceJPA.controller;

import com.example.practiceJPA.entity.Dish;
import com.example.practiceJPA.request.AddDishRequest;
import com.example.practiceJPA.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping
    public List<Dish> insertDishes(@RequestBody List<AddDishRequest> requests) {
        return menuService.insertDishes(requests);
    }


}
