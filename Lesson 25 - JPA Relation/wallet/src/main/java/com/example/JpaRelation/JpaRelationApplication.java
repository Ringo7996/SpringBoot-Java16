package com.example.JpaRelation;

import com.example.JpaRelation.entity.Account;
import com.example.JpaRelation.entity.Wallet;
import com.example.JpaRelation.repository.AccountRepository;
import com.example.JpaRelation.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaRelationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationApplication.class, args);
	}

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception{
		Wallet wallet1 = new Wallet(100);
		Wallet wallet2 = new Wallet(200);
		Wallet wallet3 = new Wallet(300);
		Wallet wallet4 = new Wallet(400);
		List<Wallet> walletList = new ArrayList<>(Arrays.asList(wallet1,wallet2,wallet3,wallet4));
		walletRepository.saveAll(walletList);

		Account account1 = new Account("Linh","123",wallet1);
		Account account2 = new Account("Linh2","123",wallet2);
		Account account3 = new Account("Linh3","123",wallet3);
		Account account4 = new Account("Linh4","123",wallet4);
		List<Account> accountList = new ArrayList<>(Arrays.asList(account1,account2,account3,account4));
		accountRepository.saveAll(accountList);
	}

}
