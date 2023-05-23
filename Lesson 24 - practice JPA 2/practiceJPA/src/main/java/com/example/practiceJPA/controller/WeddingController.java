package com.example.practiceJPA.controller;

import com.example.practiceJPA.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/wedding")
public class WeddingController {
    @Autowired
    WeddingService weddingService;

    @GetMapping
    public String calTotalCost(){
        return weddingService.calTotalCost();
    }

}
