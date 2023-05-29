package com.example.JpaRelation.service;

import com.example.JpaRelation.entity.Account;
import com.example.JpaRelation.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    public AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isEmpty()){
            // throw exception

        }
        return account.get();
    }

    @Override
    public Account updateBalanceById(Integer id, Double newBalance) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            // throw exception

        }
        Account account = accountOptional.get();
        account.getWallet().setBalance(newBalance);

        accountRepository.save(account);

        return account;
    }
}
