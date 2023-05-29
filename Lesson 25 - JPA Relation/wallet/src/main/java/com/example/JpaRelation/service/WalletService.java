package com.example.JpaRelation.service;

import com.example.JpaRelation.entity.Account;

import java.util.List;

public interface WalletService {
    List<Account> getAllAccounts();

    Account getAccountById(Integer id);

    Account updateBalanceById(Integer id, Double newBalance);
}
