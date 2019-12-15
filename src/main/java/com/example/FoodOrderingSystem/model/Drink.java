package com.example.FoodOrderingSystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name="drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_drink")
    private Long Id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "price")
    private double price;


}
