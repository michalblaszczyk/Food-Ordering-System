package com.example.FoodOrderingSystem.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Order {

    MainCourse mainCourse;
    Dessert dessert;
    Drink drink;

    double iceCubesPrice;
    double lemonPrice;
    double totalPrice;

    public void calcTotalPrice() {

        totalPrice += iceCubesPrice + lemonPrice;

        try {
            totalPrice += drink.getPrice();
        } catch (NullPointerException npe) {
            npe.getMessage();
        }

        try {
            totalPrice += mainCourse.getPrice();
        } catch (NullPointerException npe) {
            npe.getMessage();
        }

        try {
            totalPrice += dessert.getPrice();
        } catch (NullPointerException npe) {
            npe.getMessage();
        }
    }


}
