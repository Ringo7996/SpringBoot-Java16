package com.example.practice.service;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class GeneralServiceImp implements GeneralService{
    @Override
    public String getRandomString() {
        String randomString = RandomStringUtils.randomAlphanumeric(8);
        return randomString;
    }

    @Override
    public String getRandomQuote() {
        List<String> quotes = new ArrayList<>(Arrays.asList("Kiến tha lâu đầy tổ",
                "Có công mài sắt, có ngày nên kim",
                "Không thầy đố mày làm nên",
                "Học thầy không tày học bạn"));

        Random random = new Random();
        int randomNumber = random.nextInt(quotes.size());

        return quotes.get(randomNumber);
    }

    @Override
    public Double getBmi(Double weight, Double height) {
        return weight / (height * height);
    }
}
