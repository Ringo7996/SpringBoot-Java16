package com.example.color.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GetRgb implements ColorService{
    @Override
    public String getColor() {
        int RGBColor1 = (int) (Math.random() * 225);
        int RGBColor2 = (int) (Math.random() * 225);
        int RGBColor3 = (int) (Math.random() * 225);

        String color = "rgb(" + RGBColor1 + ","+ RGBColor2 +"," + RGBColor3 +")";
        return color;
    }
}
