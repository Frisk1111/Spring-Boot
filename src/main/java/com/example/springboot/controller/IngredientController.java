package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient_controller")
public class IngredientController {
    private IngredientService ingredientService;


    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @PutMapping
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {

        ingredientService.addIngredient(ingredient);

        return ResponseEntity.ok().body("Ingredient saved!");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteIngredient(@RequestBody Ingredient ingredient) {

        ingredientService.deleteIngredient(ingredient);
        return ResponseEntity.ok().body("Ingredient deleted!");
    }

    @PostMapping("{id}")
    public ResponseEntity<String> updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient ingredient) throws ChangeSetPersister.NotFoundException {
        ingredientService.updateIngredient(id, ingredient);

        return ResponseEntity.ok().body("Ingredient updated");


    }

    @GetMapping("{id}")
    public ResponseEntity<?> getIngredient(@PathVariable Long id) {

        ingredientService.getIngredient(id);

        return ResponseEntity.ok().build();

    }


}
