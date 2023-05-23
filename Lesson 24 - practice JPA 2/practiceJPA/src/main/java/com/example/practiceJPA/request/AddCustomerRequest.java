package com.example.practiceJPA.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    private String name;
    private String phone;
    private String address;
}
