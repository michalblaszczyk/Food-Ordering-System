package com.example.FoodOrderingSystem.repository;

import com.example.FoodOrderingSystem.model.Lunch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LunchRepository extends CrudRepository<Lunch,Long> {
    @Query(value="SELECT l FROM Lunch l")
    List<Lunch> getAll();
}
