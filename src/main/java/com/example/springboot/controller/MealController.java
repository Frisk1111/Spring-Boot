package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    public MealController() {

    }


    @GetMapping("/gettingMeals")
    ResponseEntity<List<Meal>> gettingAllMeals() {
        return ResponseEntity.ok(mealService.getAllMeals());
    }


    @PutMapping("/puttingMeals")
    ResponseEntity<?> addingNewMeals(@RequestBody Meal meal) {


        try {

            mealService.addMeals(meal);
            return ResponseEntity.ok("\n MEAL ADDED!!");
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @PutMapping("/updatingMeals")
    ResponseEntity<?> updatingMeals(@RequestBody Meal meal) {

        try {
            mealService.updateMeals(meal);
            return ResponseEntity.ok("MEAL UPDATED");

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }


    @DeleteMapping("/deletingMeals/{name}")
    ResponseEntity<?> deletingMeals(@PathVariable("name") String mealName) {


        mealService.deleteMeals(mealName);

        return ResponseEntity.ok("Meal deleted!!");
    }
}
