package com.example.FoodOrderingSystem;

import com.example.FoodOrderingSystem.service.RestaurantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FoodOrderingSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FoodOrderingSystemApplication.class, args);
		RestaurantService restaurantService = ctx.getBean(RestaurantService.class);

		restaurantService.setUpDatabase();
		restaurantService.printAllMenu();
		restaurantService.makeOrder();

	}

}
