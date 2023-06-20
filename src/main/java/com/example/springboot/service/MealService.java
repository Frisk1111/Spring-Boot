package com.example.springboot.service;

import com.example.springboot.dao.MealDao;
import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public MealService() {

    }


    public void addMeals(Meal meal) {
        if (meal == null) throw new IllegalArgumentException("\n A meal cannot be null!!");
        if(meal.getName() == null || meal.getName().isEmpty()) throw  new IllegalArgumentException("\n The name cannot be null!!");
        if(meal.getPrice() <= 0) throw  new IllegalArgumentException("\n the price cannot be less or equals to 0 !! ");
        if(meal.getPrice() > 100000) throw  new IllegalArgumentException("\n that price its impossible to reach!! Change it!");
        mealDao.addMeal(meal);
    }

    public void deleteMeals(String meal) {


        mealDao.deleteMeal(meal);
    }

    public void updateMeals(Meal meal) {

        if(meal.getName() == null) throw  new IllegalArgumentException("\n you cant set a empty name!");
        if(meal.getDescription()== null) throw  new IllegalArgumentException("\n you cant set a empty description!");
        mealDao.updateMeal(meal);
    }


    public List<Meal> getAllMeals() {
        return mealDao.getMealList();
    }


}
