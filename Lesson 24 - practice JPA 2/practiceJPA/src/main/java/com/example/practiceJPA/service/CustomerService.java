package com.example.practiceJPA.service;

import com.example.practiceJPA.request.AddCustomerRequest;
import com.example.practiceJPA.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer addNewCustomer(AddCustomerRequest request);

    List<Customer> getAllcustomer();

    int getCustomerNumber();
}
