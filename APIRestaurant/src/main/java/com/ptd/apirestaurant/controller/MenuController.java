package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.MenuDTO;
import com.ptd.apirestaurant.entity.Ingredient;
import com.ptd.apirestaurant.entity.Menu;
import com.ptd.apirestaurant.reponsitory.IngredientRepository;
import com.ptd.apirestaurant.service.IngredientService;
import com.ptd.apirestaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/api/menu/get-all")
    ResponseEntity<List<Menu>> findALl(){
        return new ResponseEntity<>(menuService.FindAAllMenu(), HttpStatus.OK);
    }

    @PatchMapping("/api/menu/set-food-available/{id}")
    ResponseEntity<String> setAvailableFood(@PathVariable("id") int idFood, @RequestParam("type") int type){
        String res = menuService.setFoodIsAvailable(idFood,type);
        if(res == "succes")
            return new ResponseEntity<>(new SuccessResponse("200","Success").toString(),HttpStatus.OK);
        else
            return new ResponseEntity<>(new FailureRepsone(res).toString(),HttpStatus.OK);
    }

    @PostMapping("/api/menu/create")
    ResponseEntity<Menu> createMenu(@RequestBody MenuDTO menu){
        return new ResponseEntity<>(menuService.createMenu(menu), HttpStatus.OK);
    }

    @DeleteMapping("/api/menu/delete/{menuID}")
    ResponseEntity<String> deleteMenu(@PathVariable("menuID") int id){
        if(menuService.deleteMenu(id) == true)
            return new ResponseEntity<>( new SuccessResponse("200","Success").toString(),HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone("Fail").toString(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
