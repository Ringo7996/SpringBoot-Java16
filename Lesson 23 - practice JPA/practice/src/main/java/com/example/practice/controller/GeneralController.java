package com.example.practice.controller;

import com.example.practice.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GeneralController {
    @Autowired
    GeneralService generalService;

    @GetMapping("/random")
    public String getRandomString() {
        return generalService.getRandomString();

    }

    @GetMapping("/quote")
    public String getRandomQuote() {
        return generalService.getRandomQuote();
    }

    @PostMapping("/bmi")
    public Double getBmi(@RequestParam(name = "weight") Double weight, @RequestParam(name = "height") Double height){
        return generalService.getBmi(weight,height);
    }

}
