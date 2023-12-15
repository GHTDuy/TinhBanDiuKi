package com.ptd.apirestaurant.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ptd.apirestaurant.entity.Menu;
import com.ptd.apirestaurant.reponsitory.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    private  Cloudinary cloudinary;


    public List<Menu> FindAAllMenu(){
        return menuRepository.findAll();
    }

    public String setFoodIsAvailable(Integer foodId, int type){
        try {
            Menu food = menuRepository.findMenuByProductId(foodId);
            if(food != null){
                if(type == 1)
                    food.setProductAvailable((short) 1);
                else
                    food.setProductAvailable((short) 0);
                menuRepository.save(food);
                return "success";
            }
            else return "Can not find the food";
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    public Menu createMenu(Menu menu){
        if(!menu.getFile().isEmpty()){
            try {
                Map res = this.cloudinary.uploader().upload(menu.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                menu.setImage(res.get("secure_url").toString());
            }
            catch (IOException exception){
                Logger.getLogger(MenuService.class.getName()).log(Level.SEVERE,null,exception);
            }
        }
        return menuRepository.save(menu);
    }
}
