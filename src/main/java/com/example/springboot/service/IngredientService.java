package com.example.springboot.service;

import com.example.springboot.dao.IIngredientDao;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class IngredientService {
    private final IIngredientDao IIngredientDao;

    private final List<Ingredient> ingredientList;

    @Autowired
    public IngredientService(IIngredientDao IIngredientDao) {
        this.IIngredientDao = IIngredientDao;
        this.ingredientList = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {

        ingredientList.add(ingredient);
        IIngredientDao.save((Ingredient) ingredientList);
    }

    public void updateIngredient(Ingredient ingredient) {

        ingredientList.removeIf(i -> i.getName().equals(ingredient.getName()));
        ingredientList.add(ingredient);

        IIngredientDao.save((Ingredient) ingredientList);
    }

    public void deleteIngredient(Ingredient ingredient) {

        ingredientList.removeIf(i -> i.getName().equals(ingredient.getName()));
        IIngredientDao.save((Ingredient) ingredientList);
    }

    public void getIngredient(Long id) {

       String ingredientById=  ingredientList.stream().filter(i -> i.getId().equals(id)).collect(Collectors.toSet()).toString();

       if(ingredientById.equals(id.toString())){
           IIngredientDao.findById(id);

       } else {

           System.out.println("this doesn't exist!");
       }
    }


}
