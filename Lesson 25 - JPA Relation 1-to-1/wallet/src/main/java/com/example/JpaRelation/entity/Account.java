package com.example.JpaRelation.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    @OneToOne
    @JoinColumn
    private Wallet wallet;

    public Account(String username, String password, Wallet wallet){
        this.username = username;
        this.password = password;
        this.wallet = wallet;
    }

}
