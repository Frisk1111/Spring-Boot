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


    //    Exercise 2: Create a PostMapping to update a meal by name
//
//1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
//2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
//3 - Update the meal with the corresponding name using the information from the RequestBody.


    @PostMapping("/meal/{name}")
    ResponseEntity<?> updatingByMealName(@PathVariable("name") String name, @RequestBody Meal updatedMeal) {


        //così rimuoviamo dalla lista la portata che corrisponde al PathVariable name!
        mealList.removeIf(m -> m.getName().toLowerCase().equals(name));

//aggiungiamo il body che sarà la stessa portata di prima ma con alcune specifiche aggiornate!
        this.mealList.add(updatedMeal);

        //e faccio ritornare un 200 status
        return ResponseEntity.ok("Meal updated");

    }


    //Exercise 3: Create a DeleteMapping to delete a meal by name
//
//        1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
//        2 - In the method, add a PathVariable for the name.
//        3 - Delete the meal with the corresponding name.


    @DeleteMapping("/meal/{name}")
    ResponseEntity<?> deletingMealByName(@PathVariable("name") String name) {

        //qua invece eliminiamo solo la portata che corrisponde a name!

        this.mealList.removeIf(m -> m.getName().toLowerCase().equals(name));

        return ResponseEntity.ok("\n  meal deleted!");


    }



//        Exercise 4: Create a DeleteMapping to delete all meals above a certain price
//
//        1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
//        2 - In the method, add a PathVariable for the price.
//        3 - Delete all meals with a price above the price from the PathVariable.
//

    @DeleteMapping("/meal/price/{price}")
    ResponseEntity<?> deletingAllMealsWithThePrice(@PathVariable("price") double price) {


        this.mealList.removeIf(m -> m.getPrice() > price);

        return ResponseEntity.ok(" \n the meals that above this price have been deleted!");


    }


    //        Exercise 5: Create a PutMapping to update the price of a meal by name
//
//        1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
//        2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
//        3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
//


    @PutMapping("/meal/{name}/price")
    ResponseEntity<?> updatingPricesByMealName(@PathVariable("name") String name, @RequestBody Meal newMeal) {

        //anche qua come prima rimuoviamo la portata se corrisponde a name

        this.mealList.removeIf(m -> m.getName().toLowerCase().equals(name));

        //la rimettiamo ma stavolta con il prezzo aggiornato!
        this.mealList.add(newMeal);

        return ResponseEntity.ok("\n the price of this meal its  been updated!");


    }




}






