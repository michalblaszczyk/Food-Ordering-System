package com.example.FoodOrderingSystem.repository;

import com.example.FoodOrderingSystem.model.Dessert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DessertRepository extends CrudRepository<Dessert,Long> {
    @Query(value="SELECT d FROM Dessert d")
    List<Dessert> getAll();
}
