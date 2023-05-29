package com.example.JpaRelation.repository;

import com.example.JpaRelation.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
