package com.example.springboot.Controller_Path;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MealControllerFab4 {

//
//    Exercise 4: Create a GetMapping that returns a meal by price range
//
//1 - Annotate a new class with the @RestController annotation.
//2 - Create a new endpoint "/meal/price" using the @GetMapping annotation.
//3 - In the method, add two query parameters "min" and "max" using the @RequestParam annotation.
//4 - Return a list of Meal objects with prices within the specified range.

    List<Meal> mealList = Arrays.asList(
            new Meal("Spaghetti", "Spaghetti, gnam", 9.99, true),
            new Meal("Soup", "Good for when u are sick", 89.77, false),
            new Meal("Noodles", "SPaghetti but in water", 0.32, false),
            new Meal("Ice cream", "WHATS THAT? A PLANE? A BIRD? NO! ITS THE ICE CREAM TRUCK !!!", 690.55, true),
            new Meal("Fish", "Dead fish, it smell... fishy", 3.02, true)
    );


    //da sistemare...
    @GetMapping("/meal/price/")
    public ResponseEntity<?> returningMealByRangeOfPrice( @RequestParam int min, @RequestParam int max){

        //mia idea
//        ResponseEntity<Meal> a = null;
//
//        for (Meal meal : mealList) {
//            if ( min <= meal.getPrice() && meal.getPrice() <= max){
//
//                a=  ResponseEntity.ok(meal);
//            }
//        }


        String meal = mealList.stream()
                .filter(m-> m.getPrice() >= min && m.getPrice() <= max)
                .map(m-> m.getName().toLowerCase())
                .collect(Collectors.toSet())
                .toString();

        if (meal != null) {

            return ResponseEntity.ok("Here's your meal! \n" + meal);

        } else {

            return ResponseEntity.badRequest().body("""

                      we dont have a meal between to those prices !"\
                    """);
        }



    }

}


