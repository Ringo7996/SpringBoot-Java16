package com.example.practiceJPA.service;


import com.example.practiceJPA.entity.Customer;
import com.example.practiceJPA.entity.Gift;
import com.example.practiceJPA.repository.CustomerRepository;
import com.example.practiceJPA.repository.GiftRepository;
import com.example.practiceJPA.request.AddDishRequest;
import com.example.practiceJPA.request.AddGiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiftServiceImp implements GiftService {
    @Autowired
    GiftRepository giftRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Gift addANewGift(AddGiftRequest request) {

        Optional<Customer> customerOpt = customerRepository.findById(request.getCustomerID());
        if (customerOpt.isEmpty()) {
            // throw Not found Exception
        }
            Customer customer = customerOpt.get();

        Gift newGift = Gift.builder().price(request.getPrice()).customer(customer).build();
        giftRepository.save(newGift);
        return newGift;
    }


    @Override
    public Double getTotalPrice() {
        return giftRepository.getTotalPrice();
    }
}
