package com.example.practiceJPA.repository;

import com.example.practiceJPA.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select count(*) from customer", nativeQuery = true)
    int countCustomer();

}
