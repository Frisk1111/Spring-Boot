package com.example.springboot.Controller_Path;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MealControllerFab3 {


//
//    Exercise 3: Create a GetMapping that returns a meal by any word of description
//
//1 - Annotate a new class with the @RestController annotation.
//2 - Create a new endpoint "/meal/description-match/{phrase}" using the @GetMapping annotation.
//3 - In the method, add a query parameter "description" using the @PathVariable annotation.
//4 - Return a Meal object with the corresponding description.

    List<Meal> mealList = Arrays.asList(
            new Meal("Spaghetti", "Spaghetti, gnam", 9.99, true),
            new Meal("Soup", "Good for when u are sick", 89.77, false),
            new Meal("Noodles", "SPaghetti but in water", 0.32, false),
            new Meal("Ice cream", "WHATS THAT? A PLANE? A BIRD? NO! ITS THE ICE CREAM TRUCK !!!", 65890.55, true),
            new Meal("Fish", "Dead fish, it smells... fishy", 3.02, true)
    );

    @GetMapping("/meal/description-match/{phrase}")
    public ResponseEntity<?> returningMealByDescription(@PathVariable("phrase") String phrase) {


        String meal = mealList.stream()
                .filter(m -> m.getDescription().toLowerCase().contains(phrase))
                .map(m -> m.getName().toLowerCase())
                .collect(Collectors.toSet())
                .toString();

        if (meal != null) {

            return ResponseEntity.ok("Here's your meal! \n" + meal);

        } else {

            return ResponseEntity.badRequest().body("""

                      OOPS! Try to write it in lower case and if still this happens.." +
                                        " well,IT will mean that we dont have that meal! "\
                    """);
        }

    }

}


