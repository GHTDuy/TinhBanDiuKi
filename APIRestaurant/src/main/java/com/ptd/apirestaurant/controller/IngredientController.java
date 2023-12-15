package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.entity.Ingredient;
import com.ptd.apirestaurant.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/api/ingredient/get-all-available")
    public ResponseEntity<List<Ingredient>> getListIngredientAvailable(){
        return new ResponseEntity<>(ingredientService.getListAvailableIngredient(), HttpStatus.OK);
    }

    @GetMapping("/api/ingredient/get-all-unavailable")
    public ResponseEntity<List<Ingredient>> getListUnavailableIngredient(){
        return new ResponseEntity<>(ingredientService.getListUnavailaleIngredient(),HttpStatus.OK);
    }
}
