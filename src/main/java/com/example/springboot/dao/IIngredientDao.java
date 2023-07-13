package com.example.springboot.dao;

import com.example.springboot.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientDao extends JpaRepository<Ingredient, Long> {


}
