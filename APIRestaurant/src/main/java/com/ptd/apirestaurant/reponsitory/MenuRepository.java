package com.ptd.apirestaurant.reponsitory;


import com.ptd.apirestaurant.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    List<Menu> findAll();

    Menu findMenuByProductId(int foodId);

}
