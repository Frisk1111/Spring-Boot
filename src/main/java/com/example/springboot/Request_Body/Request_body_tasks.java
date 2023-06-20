package com.example.springboot.Request_Body;


import com.example.springboot.model.Meal;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Request_body_tasks {

    //
//    Exercise 1: Create a PutMapping to add a new meal
//
//  1 - Create a new endpoint "/meal" using the @PostMapping annotation.
//  2 - In the method, add a RequestBody for the new Meal object.
//  3- Add the meal for the list.

    List<Meal> mealList = new ArrayList<>();


    @PutMapping("/put/meal")
    ResponseEntity<?> puttingMeal(@RequestBody Meal meal) {


        //se meal é diverso da null
        if (meal != null) {

            //aggiungilo alla lista!
            mealList.add(meal);
            //e fai ritornare un 200
            return ResponseEntity.ok("\n  Meal added!!");
        } else {

            //altrimenti fai ritornare una badRequest!
            return ResponseEntity.badRequest().body("\n Meal cannot be null ! !");

        }


    }

    //per vedere come cambiano con le operazioni rest!
    @GetMapping("/getMeal")
    ResponseEntity<?> gettingMeal() {


        if (mealList.isEmpty()) {
            return ResponseEntity.badRequest().body("\n This list is empty!!");



        } else{

            return  ResponseEntity.ok(mealList);
        }
    }




}






