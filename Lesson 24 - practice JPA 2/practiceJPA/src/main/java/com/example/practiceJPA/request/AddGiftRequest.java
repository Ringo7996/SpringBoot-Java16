package com.example.practiceJPA.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddGiftRequest {
    int customerID;
    double price;
}
