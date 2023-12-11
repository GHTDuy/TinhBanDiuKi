package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.entity.Ingredient;
import com.ptd.apirestaurant.entity.Menu;
import com.ptd.apirestaurant.reponsitory.IngredientRepository;
import com.ptd.apirestaurant.service.IngredientService;
import com.ptd.apirestaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
