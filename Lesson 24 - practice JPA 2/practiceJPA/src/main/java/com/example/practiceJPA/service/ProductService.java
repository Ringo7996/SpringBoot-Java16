package com.example.practiceJPA.service;

import com.example.practiceJPA.entity.Customer;
import com.example.practiceJPA.entity.Product;
import com.example.practiceJPA.request.AddCustomerRequest;
import com.example.practiceJPA.request.AddProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> addNewProducts(List<AddProductRequest> request);

    Double getTotalPrice();
}
