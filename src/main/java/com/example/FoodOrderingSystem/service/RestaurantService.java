package com.example.FoodOrderingSystem.service;

import com.example.FoodOrderingSystem.model.*;
import com.example.FoodOrderingSystem.model.Cusine.Cuisine;
import com.example.FoodOrderingSystem.repository.DessertRepository;
import com.example.FoodOrderingSystem.repository.DrinkRepository;
import com.example.FoodOrderingSystem.repository.LunchRepository;
import com.example.FoodOrderingSystem.repository.MainCourseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class RestaurantService implements IRestaurant {

    @Autowired
    private DessertRepository dessertRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private MainCourseRepository mainCourseRepository;
    @Autowired
    private LunchRepository lunchRepository;

    private List<Lunch> lunches;
    private List<Drink> drinks;
    private List<MainCourse> mainCourses;
    private List<Dessert> desserts;

    static Order order = new Order();

    @Override
    public void setUpDatabase(){
        lunches = lunchRepository.getAll();
        drinks = drinkRepository.getAll();
        mainCourses = mainCourseRepository.getAll();
        desserts = dessertRepository.getAll();
    }
    @Override
    public void printAllMenu(){
        System.out.println("Lunches: ");
        for(Lunch lunch : lunches){
            System.out.println(lunch.toString());
        }

        System.out.println("Drinks: ");
        for(Drink drink : drinks){
            System.out.println(drink.toString());
        }

        System.out.println("Desserts: ");
        for(Dessert dessert : desserts){
            System.out.println(dessert.toString());
        }

        System.out.println("Main Courses: ");
        for(MainCourse mainCourse : mainCourses){
            System.out.println(mainCourse.toString());
        }
    }

    @Override
    public void makeOrder(){
        System.out.println("How can i help you?\n1.Order\n2.Quit");
        int choose = validator(1,2);

        switch(choose) {
            case 1: askedForOrder();
                break;
            case 2: System.out.println("Have a nice day!");
                return;
        }

        order.calcTotalPrice();

        System.out.println("\nYour Order = " + order.toString() + "\n");
        System.out.println("Total cost = " + order.getTotalPrice() + "PLN");
        System.out.println("Enjoy your meal!\n");
        System.out.println("------------------------");

        System.out.println("\nClosing...\n");

    }
    private int validator(int min, int max){
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        boolean valid = false;

        while(!valid){
            try{
                choose = scanner.nextInt();
                if(choose >= min && choose <= max){
                    valid = true;
                }
                else{
                    System.out.println("Wrong number");
                }
            }catch(InputMismatchException ime){
                System.out.println("Wrong format");
                scanner.next();
            }
        }
        return choose;
    }
    private void orderDrink(){
        System.out.println("Maybe something to drink?");
        System.out.println("1.Yes\n2.No");
        int choose = validator(1,2);

        switch(choose){
            case 1:
                askedForDrink();
                break;
            case 2:
                System.out.println("As you wish!");
                break;
        }
    }
    private void askedForDrink(){
        int max = 0;
        System.out.println("Drink to order:");
        for (Drink drink : drinks) {
            System.out.print(drink.getId() + ". ");
            System.out.print(drink.getName() + " - " + drink.getPrice() + "PLN\n");
            max++;
        }

        int choose = validator(1, max);
        order.setDrink(drinks.get(choose - 1));

        System.out.println("Ice Cubes or Lemons?\n1. Ice Cubes (2pln)\n2. Lemons (2pln)\n3. Both (4pln)\n4. None");

        choose = validator(1,4);

        final double PRICE = 2.0;

        switch (choose){
            case 1: order.setIceCubesPrice(PRICE);
                break;
            case 2: order.setLemonPrice(PRICE);
                break;
            case 3: order.setIceCubesPrice(PRICE);
                order.setLemonPrice(PRICE);
                break;
        }
    }
    private void askedForOrder() {
        System.out.println("Pick cuisine\n1. Polish\n2.Mexican\n3.Italian\n");

        int choose = validator(1,3);

        switch(choose) {
            case 1: System.out.println("You choose Polish Food\nChoose LUNCH. There are our Polish LUNCH sets");
                orderLunch(Cuisine.POLISH);
                orderDrink();
                break;
            case 2: System.out.println("You choose Mexican Food.\nChoose LUNCH. There are our Mexican LUNCH sets");
                orderLunch(Cuisine.MEXICAN);
                orderDrink();
                break;
            case 3: System.out.println("You choose Italian Food.\nChoose LUNCH. There are our Italian LUNCH sets");
                orderLunch(Cuisine.ITALIAN);
                orderDrink();
                break;
        }
    }
    private void orderLunch(Cuisine cuisine) {

        // -1 in get() methods due to difference between entity id and List<> indexing

        int count = 1;

        MainCourse mainCourse;
        Dessert desert;

        Map<Integer,Lunch> lunchLongMap = new HashMap<>();

        for (Lunch lunch : lunches) {

            if (lunch.getCuisine() == cuisine) {

                mainCourse = mainCourses.get(Math.toIntExact(lunch.getMainCourseId()) - 1);
                desert = desserts.get(Math.toIntExact(lunch.getDesertId()) - 1);

                // PUT NUMBER + CORRESPONDING LUNCH to MAP for future ORDER assignment
                lunchLongMap.put(count,lunch);

                System.out.print(count + ". ");
                System.out.print("Set name: " + lunch.getName());
                System.out.print(", Main Course: " + mainCourse.getName() + " - " + mainCourse.getPrice() + "PLN");
                System.out.print(", Desert: " + desert.getName() + " - " + desert.getPrice() + "PLN" + "\n");

                count++;
            }

        }


        int choose = validator(1, count - 1);

        Lunch yourLunch = lunchLongMap.get(choose);

        MainCourse yourMainCourse = mainCourses.get(Math.toIntExact(yourLunch.getMainCourseId()) - 1);
        Dessert yourDesert = desserts.get(Math.toIntExact(yourLunch.getDesertId()) - 1);

        order.setMainCourse(yourMainCourse);
        order.setDessert(yourDesert);

    }
}
