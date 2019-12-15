package com.example.FoodOrderingSystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="maincourses")
public class MainCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_maincourses")
    private Long mainCourse;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "price")
    private double price;


}
