package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListResourceBundle;


@Repository
public interface TableRepository extends JpaRepository<Table,Integer> {
    Table findByTableId(int tableId);

    Table getTableByTableId(int tableId);

    @Query(nativeQuery = true, value = "SELECT * FROM restaurant_management.table")
    List<Table> getAllCus();

    @Query(nativeQuery = true, value = "SELECT * FROM restaurant_management.table where table_id = :id")
    List<Table> getTableCus(@Param("id") int id);
}
