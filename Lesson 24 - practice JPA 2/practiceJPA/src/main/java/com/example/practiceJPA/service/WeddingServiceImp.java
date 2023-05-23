package com.example.practiceJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeddingServiceImp implements WeddingService {
    @Autowired
    CustomerService customerService;
    @Autowired
    GiftService giftService;
    @Autowired
    MenuService menuService;
    @Autowired
    ProductService productService;

    public String calTotalCost() {
        int mealTableNumber;
        if (customerService.getCustomerNumber() % 6 == 0) {
            mealTableNumber = customerService.getCustomerNumber() / 6;
        } else {
            mealTableNumber = customerService.getCustomerNumber() / 6 + 1;
        }

        System.out.println(mealTableNumber);

        return
                "Cost for a meal table is " + menuService.getTotalPrice() +
                "\nCustomer number is " + customerService.getCustomerNumber() +


                "\nTotal product cost is " + productService.getTotalPrice() +
                "\nTotal cost for wedding meal is " + menuService.getTotalPrice() * mealTableNumber +
                "\nTotal value of gifts from customers is " + giftService.getTotalPrice();
    }
}
