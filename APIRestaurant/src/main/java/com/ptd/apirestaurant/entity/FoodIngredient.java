/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptd.apirestaurant.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 *
 * @author DELL
 */
@Entity
@Table(name = "food_ingredient")

@NamedQueries({
    @NamedQuery(name = "FoodIngredient.findAll", query = "SELECT f FROM FoodIngredient f"),
    @NamedQuery(name = "FoodIngredient.findByFoodId", query = "SELECT f FROM FoodIngredient f WHERE f.foodIngredientPK.foodId = :foodId"),
    @NamedQuery(name = "FoodIngredient.findByIngredientId", query = "SELECT f FROM FoodIngredient f WHERE f.foodIngredientPK.ingredientId = :ingredientId"),
    @NamedQuery(name = "FoodIngredient.findByAmount", query = "SELECT f FROM FoodIngredient f WHERE f.amount = :amount")})
public class FoodIngredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FoodIngredientPK foodIngredientPK;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredient ingredient;
    @JoinColumn(name = "food_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;

    public FoodIngredient() {
    }

    public FoodIngredient(FoodIngredientPK foodIngredientPK) {
        this.foodIngredientPK = foodIngredientPK;
    }

    public FoodIngredient(FoodIngredientPK foodIngredientPK, int amount) {
        this.foodIngredientPK = foodIngredientPK;
        this.amount = amount;
    }

    public FoodIngredient(int foodId, int ingredientId) {
        this.foodIngredientPK = new FoodIngredientPK(foodId, ingredientId);
    }

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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodIngredientPK != null ? foodIngredientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodIngredient)) {
            return false;
        }
        FoodIngredient other = (FoodIngredient) object;
        if ((this.foodIngredientPK == null && other.foodIngredientPK != null) || (this.foodIngredientPK != null && !this.foodIngredientPK.equals(other.foodIngredientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.FoodIngredient[ foodIngredientPK=" + foodIngredientPK + " ]";
    }
    
}
