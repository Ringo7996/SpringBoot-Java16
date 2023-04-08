package com.example.color.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GetColorName implements ColorService{
    @Override
    public String getColor() {
        String[] color = {"red","blue","green","yellow","black","white"};
        int index = (int) (Math.random() * color.length);

        return color[index];
    }
}
