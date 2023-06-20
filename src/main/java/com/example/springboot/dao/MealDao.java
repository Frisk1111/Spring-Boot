package com.example.springboot.dao;


import com.example.springboot.model.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDao {

    private final List<Meal> mealList = new ArrayList<>();

    public void addMeal(Meal meal){
        mealList.add(meal);
    }

    public void updateMeal(Meal meal){
        mealList.removeIf(m-> m.getName().equals(meal.getName()));
        mealList.add(meal);
    }

    public void deleteMeal(String meal){
        mealList.removeIf(m -> m.getName().equals(meal));
    }


    public List<Meal> getMealList() {
        return mealList;
    }
}
