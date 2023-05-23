package com.example.practiceJPA.service;

import com.example.practiceJPA.request.AddCustomerRequest;
import com.example.practiceJPA.entity.Customer;
import com.example.practiceJPA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addNewCustomer(AddCustomerRequest request) {
        Customer newCustomer = Customer.builder().name(request.getName())
                .phone(request.getPhone()).address(request.getAddress()).build();

        customerRepository.save(newCustomer);
        return newCustomer;
    }

    @Override
    public List<Customer> getAllcustomer() {
        return customerRepository.findAll();
    }

    @Override
    public int getCustomerNumber() {
        return customerRepository.countCustomer();
    }
}
