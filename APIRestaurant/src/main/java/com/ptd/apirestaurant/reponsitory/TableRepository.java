package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableRepository extends JpaRepository<Table,Integer> {
    Table findByTableId(int id);
}
