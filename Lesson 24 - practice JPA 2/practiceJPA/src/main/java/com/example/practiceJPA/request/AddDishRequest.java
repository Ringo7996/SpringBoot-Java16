package com.example.practiceJPA.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDishRequest {
    private String name;
    private double price;
}
