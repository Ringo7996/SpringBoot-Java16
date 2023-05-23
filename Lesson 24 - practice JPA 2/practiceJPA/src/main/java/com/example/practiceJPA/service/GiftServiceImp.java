package com.example.practiceJPA.service;


import com.example.practiceJPA.entity.Gift;
import com.example.practiceJPA.repository.GiftRepository;
import com.example.practiceJPA.request.AddDishRequest;
import com.example.practiceJPA.request.AddGiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftServiceImp implements GiftService {
    @Autowired
    GiftRepository giftRepository;

    @Override
    public Gift addANewGift(AddGiftRequest request) {
        Gift newGift = Gift.builder().price(request.getPrice()).customerID(request.getCustomerID()).build();
        giftRepository.save(newGift);
        return newGift;
    }

    @Override
    public Double getTotalPrice() {
        return giftRepository.getTotalPrice();
    }
}
