package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.dto.IngredientDTO;
import com.ptd.apirestaurant.entity.Ingredient;
import com.ptd.apirestaurant.reponsitory.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    private Ingredient toEnity(IngredientDTO ingredientDTO){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(ingredient.getIngredientId());
        ingredient.setIngredientName(ingredientDTO.getIngredientName());
        ingredient.setAmount(ingredient.getAmount());
        ingredient.setExpiredDate(ingredientDTO.getExpiredDate());
        ingredient.setImportDate(ingredientDTO.getImportDate());
        ingredient.setDisabled(ingredientDTO.getDisabled());
        return ingredient;
    }
    public List<Ingredient> getListIngredientByFoodID(int id){
        return ingredientRepository.findAllByIDFood(id);
    }

    public List<Ingredient> getListAvailableIngredient(){
        return ingredientRepository.listAvailableIngredient();
    }

    public  List<Ingredient> getListUnavailaleIngredient(){return ingredientRepository.listUnAvailableIngredient();}

    public Ingredient createIngredient(IngredientDTO ingredientDTO){
        try {
            return ingredientRepository.save(toEnity(ingredientDTO));
        }catch (Exception exception){
            return null;
        }
    }

    public Boolean deleteIngredient(int idIngredient){
        try {
            Ingredient ingredient = ingredientRepository.findByIngredientId(idIngredient);
            ingredient.setDisabled(true);
            ingredientRepository.save(ingredient);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
