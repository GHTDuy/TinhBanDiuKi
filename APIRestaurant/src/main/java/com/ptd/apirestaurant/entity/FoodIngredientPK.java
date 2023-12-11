/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptd.apirestaurant.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


/**
 *
 * @author DELL
 */
@Embeddable
public class FoodIngredientPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "food_id")
    private int foodId;
    @Basic(optional = false)
    @Column(name = "ingredient_id")
    private int ingredientId;

    public FoodIngredientPK() {
    }

    public FoodIngredientPK(int foodId, int ingredientId) {
        this.foodId = foodId;
        this.ingredientId = ingredientId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) foodId;
        hash += (int) ingredientId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodIngredientPK)) {
            return false;
        }
        FoodIngredientPK other = (FoodIngredientPK) object;
        if (this.foodId != other.foodId) {
            return false;
        }
        if (this.ingredientId != other.ingredientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.FoodIngredientPK[ foodId=" + foodId + ", ingredientId=" + ingredientId + " ]";
    }
    
}
