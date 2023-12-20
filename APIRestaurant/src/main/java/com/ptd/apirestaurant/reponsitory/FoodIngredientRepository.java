package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.FoodIngredient;
import com.ptd.apirestaurant.entity.FoodIngredientPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodIngredientRepository extends JpaRepository<FoodIngredient, FoodIngredientPK > {
    FoodIngredient findFoodIngredientByFoodIngredientPK(FoodIngredientPK key);
}
