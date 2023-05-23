package com.example.practiceJPA.service;

import com.example.practiceJPA.entity.Dish;
import com.example.practiceJPA.repository.MenuRepository;
import com.example.practiceJPA.request.AddDishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Dish> insertDishes(List<AddDishRequest> requests) {
        List<Dish> menu = new ArrayList<>();
        for (AddDishRequest dish : requests) {
            Dish newDish = Dish.builder().name(dish.getName()).price(dish.getPrice()).build();
            menu.add(newDish);
        }
        menuRepository.saveAll(menu);
        return menu;
    }

    @Override
    public Double getTotalPrice() {
        return menuRepository.getPriceOfAllDishes();
    }
}
