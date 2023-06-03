package com.example.JpaRelation.repository;

import com.example.JpaRelation.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
