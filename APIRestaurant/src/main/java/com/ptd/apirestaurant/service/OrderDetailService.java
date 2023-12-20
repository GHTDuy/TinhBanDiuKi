package com.ptd.apirestaurant.service;


import com.ptd.apirestaurant.entity.*;
import com.ptd.apirestaurant.reponsitory.FoodIngredientRepository;
import com.ptd.apirestaurant.reponsitory.IngredientRepository;
import com.ptd.apirestaurant.reponsitory.MenuRepository;
import com.ptd.apirestaurant.reponsitory.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    FoodIngredientRepository foodIngredientRepository;

    public String makeOrder(Map<Integer,Integer> listFood, int orderID){

        try {
            for(Map.Entry<Integer, Integer> entry : listFood.entrySet()) {
                List<Ingredient> ingredients = ingredientRepository.findAllByIDFood(entry.getKey());
                Menu menu = menuRepository.findMenuByProductId(entry.getKey());
                for(Ingredient ingredient: ingredients){
                    FoodIngredientPK key = new FoodIngredientPK(menu.getProductId(), ingredient.getIngredientId());
                    FoodIngredient foodIngredient = foodIngredientRepository.findFoodIngredientByFoodIngredientPK(key);
                    if (ingredient.getAmount() < foodIngredient.getAmount()) {
                        return "Ingredient " + ingredient.getIngredientName() + " is not enough";
                    }
                    else {
                        try {
                            ingredient.setAmount(ingredient.getAmount() - foodIngredient.getAmount());
                            ingredientRepository.save(ingredient);
                        }catch (Exception exception){
                            return exception.getMessage();
                        }
                    }
                }
                OrderDetailPK orderDetailPK = new OrderDetailPK(entry.getKey(),orderID);
                OrderDetail order = new OrderDetail(orderDetailPK,entry.getValue());
                orderDetailRepository.save(order);
            }
            return "Success";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
    public List<OrderDetail> getOrderDetailByOrderId(int orderId){
        return orderDetailRepository.findByOrderId(orderId);
    }
}
