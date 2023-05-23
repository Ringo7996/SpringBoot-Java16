package com.example.practiceJPA.controller;


import com.example.practiceJPA.request.AddCustomerRequest;
import com.example.practiceJPA.entity.Customer;
import com.example.practiceJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllcustomer();
    }

    @PostMapping
    public Customer insertANewCustomer(@RequestBody AddCustomerRequest request){
       return customerService.addNewCustomer(request);
    }


}
