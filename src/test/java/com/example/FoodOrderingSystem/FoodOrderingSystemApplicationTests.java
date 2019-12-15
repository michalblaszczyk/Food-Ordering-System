package com.example.FoodOrderingSystem;

import com.example.FoodOrderingSystem.model.Dessert;
import com.example.FoodOrderingSystem.model.Drink;
import com.example.FoodOrderingSystem.model.MainCourse;
import com.example.FoodOrderingSystem.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodOrderingSystemApplicationTests {

	private Dessert desert;
	private MainCourse mainCourse;
	private Drink drink;

	private Order order;

	@Before
	public void setUp() {
		desert = new Dessert();
		mainCourse = new MainCourse();
		drink = new Drink();

		order = new Order();

		mainCourse.setPrice(40.0);
		desert.setPrice(10.0);
		drink.setPrice(20.0);

		order.setMainCourse(mainCourse);
		order.setDessert(desert);
		order.setDrink(drink);

	}

	@Test
	public void shouldCheckOrderFields() {

		Assert.assertNotNull(order.getMainCourse());
		Assert.assertNotNull(order.getDessert());
		Assert.assertNotNull(order.getDrink());

	}

	@Test
	public void shouldCalculateTotalPrice() {
		order.calcTotalPrice();
		Assert.assertEquals(70.0, order.getTotalPrice(), 0.0);
	}

}
