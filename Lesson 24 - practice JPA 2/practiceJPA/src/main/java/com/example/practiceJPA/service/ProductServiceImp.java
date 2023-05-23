package com.example.practiceJPA.service;

import com.example.practiceJPA.entity.Product;
import com.example.practiceJPA.repository.ProductRepository;
import com.example.practiceJPA.request.AddProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> addNewProducts(List<AddProductRequest> request) {
        List<Product> newProducts = new ArrayList<>();
        for (AddProductRequest req : request) {
            Product newProduct = Product.builder().name(req.getName()).price(req.getPrice()).quantity(req.getQuantity())
                    .unit(req.getUnit()).type(req.getType()).build();
            newProducts.add(newProduct);
        }
        productRepository.saveAll(newProducts);

        return newProducts;
    }

    @Override
    public Double getTotalPrice() {
        return productRepository.getTotalPrice();
    }
}
