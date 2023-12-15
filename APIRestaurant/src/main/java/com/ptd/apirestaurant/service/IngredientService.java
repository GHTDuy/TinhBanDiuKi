package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.entity.Ingredient;
import com.ptd.apirestaurant.reponsitory.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;
    public List<Ingredient> getListIngredientByFoodID(int id){
        return ingredientRepository.findAllByIDFood(id);
    }

    public List<Ingredient> getListAvailableIngredient(){
        return ingredientRepository.listAvailableIngredient();
    }

    public  List<Ingredient> getListUnavailaleIngredient(){return ingredientRepository.listUnAvailableIngredient();}
}
