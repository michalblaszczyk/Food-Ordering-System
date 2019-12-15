package com.example.FoodOrderingSystem.repository;

import com.example.FoodOrderingSystem.model.Drink;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DrinkRepository extends CrudRepository<Drink,Long> {

    @Query(value="SELECT d FROM Drink d")
    List<Drink> getAll();
}
