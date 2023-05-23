package com.example.practiceJPA.request;

import com.example.practiceJPA.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    private String name;
    private double price;
    private int quantity;
    private String unit;
    private String type;
}
