package com.example.color.service;

import org.springframework.stereotype.Service;

@Service
public class GetHex implements ColorService{
    @Override
    public String getColor() {
        String[] letters = "0123456789ABCDEF".split("");
        String color = "#";
        for (int i = 0; i < 6; i++) {
            color += letters[(int) (Math.random() * 16)];
        }
        return color;
    }
}
