package com.example.practiceJPA.controller;

import com.example.practiceJPA.entity.Dish;
import com.example.practiceJPA.entity.Gift;
import com.example.practiceJPA.request.AddDishRequest;
import com.example.practiceJPA.request.AddGiftRequest;
import com.example.practiceJPA.service.GiftService;
import com.example.practiceJPA.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gift")
public class GiftController {
    @Autowired
    GiftService giftService;

    @PostMapping
    public Gift insertDishes(@RequestBody AddGiftRequest requests) {
        return giftService.addANewGift(requests);
    }

}
