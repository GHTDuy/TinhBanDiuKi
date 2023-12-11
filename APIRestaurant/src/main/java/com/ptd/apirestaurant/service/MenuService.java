package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.entity.Menu;
import com.ptd.apirestaurant.reponsitory.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public List<Menu> FindAAllMenu(){
        return menuRepository.findAll();
    }
}
