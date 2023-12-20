package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.IngredientDTO;
import com.ptd.apirestaurant.entity.Ingredient;
import com.ptd.apirestaurant.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/ingredient/create")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody IngredientDTO ingredientDTO){
        return new ResponseEntity<>(ingredientService.createIngredient(ingredientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/api/ingredient/delete/{ingredientID}")
    public ResponseEntity<String> deleteIngredient(@PathVariable("ingredientID") int id){
        if(ingredientService.deleteIngredient(id) == true)
            return new ResponseEntity<>( new SuccessResponse("200","Success").toString(),HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone("Fail").toString(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
