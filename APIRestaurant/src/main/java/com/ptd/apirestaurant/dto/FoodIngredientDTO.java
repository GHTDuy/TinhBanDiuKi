package com.ptd.apirestaurant.dto;

import com.ptd.apirestaurant.entity.FoodIngredientPK;
import com.ptd.apirestaurant.entity.Ingredient;
import com.ptd.apirestaurant.entity.Menu;
import jakarta.persistence.*;

public class FoodIngredientDTO {
    protected FoodIngredientPK foodIngredientPK;

    public FoodIngredientPK getFoodIngredientPK() {
        return foodIngredientPK;
    }

    public void setFoodIngredientPK(FoodIngredientPK foodIngredientPK) {
        this.foodIngredientPK = foodIngredientPK;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Integer getIngredient() {
        return ingredient;
    }

    public void setIngredient(Integer ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getMenu() {
        return menu;
    }

    public void setMenu(Integer menu) {
        this.menu = menu;
    }

    private int amount;
    private Integer ingredient;
    private Integer menu;
}
