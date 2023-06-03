package com.example.JpaRelation.controller;


import com.example.JpaRelation.entity.Account;
import com.example.JpaRelation.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping(value = "/wallet")
    public List<Account> getAllAccounts(){
        return walletService.getAllAccounts();
    }

    @GetMapping(value = "/wallet/{id}")
    public Account getAccountById(@PathVariable(name = "id")Integer id){
        return walletService.getAccountById(id);
    }

    @PostMapping(value = "/wallet/{id}")
    public Account updateBalanceById(@PathVariable(name = "id")Integer id, @RequestParam Double newBalance){
        return walletService.updateBalanceById(id,newBalance);
    }

}
