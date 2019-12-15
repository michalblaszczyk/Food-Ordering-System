package com.example.FoodOrderingSystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="desserts")
public class Dessert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_desserts")
    private Long desertId;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public Long getDesertId() {
        return desertId;
    }


}
