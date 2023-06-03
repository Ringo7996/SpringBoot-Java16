package com.example.JpaRelation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@ToString
@Getter
@Setter
@Entity
@Table(name = "customer")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    // cascade: tác động đến cha thì tac động đến cả con
    // FetchType
    // LAzy: Khi nào sử dụng mới query, mặc định khi có Many đằng sau, khi chưa động đến "orders" thì chưa query đến.
    //Eage: Query luôn dữ liệu liên quanm, mặc định khi có One đănng sau.
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Order> orders;

}