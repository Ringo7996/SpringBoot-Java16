package com.example.practiceJPA.service;

import com.example.practiceJPA.entity.Gift;
import com.example.practiceJPA.request.AddDishRequest;
import com.example.practiceJPA.request.AddGiftRequest;

public interface GiftService {

    Gift addANewGift(AddGiftRequest request);
    Double getTotalPrice();
}
