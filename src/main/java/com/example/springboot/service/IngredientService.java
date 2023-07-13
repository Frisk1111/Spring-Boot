package com.example.springboot.service;

import com.example.springboot.dao.IIngredientDao;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


@Service
public class IngredientService {
    private final IIngredientDao IIngredientDao;

    @Autowired
    public IngredientService(IIngredientDao IIngredientDao) {
        this.IIngredientDao = IIngredientDao;

    }

    public void addIngredient(Ingredient ingredient) {


        IIngredientDao.save(ingredient);
    }

    public void updateIngredient(Long id, Ingredient ingredient) throws ChangeSetPersister.NotFoundException {


        Ingredient existingIngredient = IIngredientDao.getReferenceById(id);

        if (existingIngredient.getId().equals(id)) {


            existingIngredient.setName(ingredient.getName());
            existingIngredient.setVegetarian(ingredient.isVegetarian());
            existingIngredient.setGlutenFree(ingredient.isGlutenFree());
            existingIngredient.setVegan(ingredient.isVegan());
            existingIngredient.setLactoseFree(ingredient.isLactoseFree());

            IIngredientDao.save(existingIngredient);

        } else {

            System.out.println("Ingredient not found!!");

            throw new ChangeSetPersister.NotFoundException();

        }


    }

    public void deleteIngredient(Ingredient ingredient) {

        IIngredientDao.delete(ingredient);
    }

    public void getIngredient(Long id) {


        IIngredientDao.getReferenceById(id);

    }


}
