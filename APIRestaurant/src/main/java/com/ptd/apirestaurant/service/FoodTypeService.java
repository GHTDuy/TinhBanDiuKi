package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.dto.FoodTypeDTO;
import com.ptd.apirestaurant.entity.FoodType;
import com.ptd.apirestaurant.reponsitory.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeService {
    @Autowired
    FoodTypeRepository foodTypeRepository;
    private FoodType toEntiry(FoodTypeDTO foodTypeDTO){
        FoodType foodType = new FoodType();
        foodType.setTypeId(foodTypeDTO.getTypeId());
        foodType.setTypeName(foodTypeDTO.getTypeName());
        foodType.setDisabled(foodTypeDTO.getDisabled());
        return foodType;
    }
    public FoodType createFoodType(FoodTypeDTO foodTypeDTO){
        return foodTypeRepository.save(toEntiry(foodTypeDTO));
    }

    public Boolean deleteFoodType(int idFoodType){
        try {
            FoodType foodType = foodTypeRepository.findByTypeId(idFoodType);
            foodType.setDisabled(true);
            foodTypeRepository.save(foodType);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public List<FoodType> getAllFoodType(){
        return foodTypeRepository.findAll();
    }
}
