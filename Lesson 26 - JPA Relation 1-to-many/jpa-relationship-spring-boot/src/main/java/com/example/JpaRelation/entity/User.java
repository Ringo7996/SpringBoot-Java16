package com.example.JpaRelation.entity;

import jakarta.persistence.*;
import lombok.*;


@ToString
@Getter
@Setter
@Entity
@Table(name = "user")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;
}