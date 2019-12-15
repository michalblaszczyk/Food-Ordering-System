package com.example.FoodOrderingSystem.repository;


import com.example.FoodOrderingSystem.model.MainCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MainCourseRepository extends CrudRepository<MainCourse,Long> {
    @Query(value="SELECT m FROM MainCourse m")
    List<MainCourse> getAll();
}
