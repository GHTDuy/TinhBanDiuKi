package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType,Integer> {
    FoodType findByTypeId(int id);
}
