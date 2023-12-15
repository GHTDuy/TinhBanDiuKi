package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {


    @Query(nativeQuery = true, value = "SELECT c.* FROM restaurant_management.menu a join restaurant_management.food_ingredient b on a.product_id = b.food_id \n" +
            "join restaurant_management.ingredient c on c.ingredient_id = b.ingredient_id where a.product_id = :id")
    List<Ingredient> findAllByIDFood(@Param("id") int id);

    @Query("select i from Ingredient i" +
            " where i.amount > 0 and i.isDisabled = false" +
            " and i.expiredDate > current date and i.importDate < current date ")
    List<Ingredient> listAvailableIngredient();

    @Query ("select i from Ingredient i where i.amount =0")
    List<Ingredient> listUnAvailableIngredient();
}
