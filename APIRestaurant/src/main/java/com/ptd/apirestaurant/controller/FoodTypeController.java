package com.ptd.apirestaurant.controller;

import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.FoodTypeDTO;
import com.ptd.apirestaurant.entity.FoodType;
import com.ptd.apirestaurant.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FoodTypeController {
    @Autowired
    FoodTypeService foodTypeService;

    @GetMapping("/api/food-type/get-all")
     ResponseEntity<List<FoodType>> getAllFoodType(){
         return  new ResponseEntity<>(foodTypeService.getAllFoodType(), HttpStatus.OK);
     }

     @DeleteMapping("/api/food-type/delete/{foodTypeID}")
    ResponseEntity<String> deleteFoodType(@PathVariable("foodTypeID") int foodTypeId ){
        if(foodTypeService.deleteFoodType(foodTypeId) == true)
            return new ResponseEntity<>( new SuccessResponse("200","Success").toString(),HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone("Fail").toString(),HttpStatus.INTERNAL_SERVER_ERROR);
     }

     @PostMapping("/api/food-type/create")
    ResponseEntity<FoodType> createFoodType(@RequestBody FoodTypeDTO foodTypeDTO){
        return new ResponseEntity<>(foodTypeService.createFoodType(foodTypeDTO), HttpStatus.OK);
     }
}
