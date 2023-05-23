package com.example.practiceJPA.controller;

import com.example.practiceJPA.entity.Customer;
import com.example.practiceJPA.entity.Product;
import com.example.practiceJPA.request.AddProductRequest;
import com.example.practiceJPA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public List<Product> insertANewCustomer(@RequestBody List<AddProductRequest> request) {
        return productService.addNewProducts(request);
    }
}
