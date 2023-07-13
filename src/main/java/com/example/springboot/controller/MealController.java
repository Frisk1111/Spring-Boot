package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping("/meal")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping("/meal/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.ok().body("MEal DEleted!");
    }

    @PostMapping("/meal")
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals() {
        return ResponseEntity.ok(mealService.getSummerMeals());
    }


    @GetMapping("/winter-meals")
    public ResponseEntity<?> getWinterMeals(){

        return ResponseEntity.ok(mealService.getWinterMeals());
    }

}