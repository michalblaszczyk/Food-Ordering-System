package com.example.FoodOrderingSystem.model;

import com.example.FoodOrderingSystem.model.Cusine.Cuisine;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lunches")
public class Lunch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long lunchId;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "cuisine")
    private Cuisine cuisine;

    @Column(name = "maincourse_id")
    private Long mainCourseId;

    @Column(name = "dessert_id")
    private Long desertId;


}
