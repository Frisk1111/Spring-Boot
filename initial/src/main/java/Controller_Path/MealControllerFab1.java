package Controller_Path;

import model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

public class MealControllerFab1 {
    List<Meal> mealList = Arrays.asList
            (new Meal("Spaghetti", "Spaghetti, gnam", 9.99, true),
                    new Meal("Soup", "Good for when u are sick", 89.77, false),
                    new Meal("Noodles", "SPaghetti but in water", 0.32, false),
                    new Meal("Ice cream", "WHATS THAT? A PLANE? A BIRD? NO! ITS THE ICE CREAM TRUCK", 65890.55, true),
                    new Meal("Fish", "Dead fish, it smell... fishy", 3.02, true));


    @GetMapping("/meals")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("\n OK " + mealList);
    }
}
