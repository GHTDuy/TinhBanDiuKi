package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.dto.TableDTO;
import com.ptd.apirestaurant.entity.Table;
import com.ptd.apirestaurant.reponsitory.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;

    private Table toEntity(TableDTO tableDTO){
        Table table = new Table();
        table.setTableId(tableDTO.getTableId());
        table.setNumberOfSeat(tableDTO.getNumberOfSeat());
        table.setIsAvilable(tableDTO.getIsAvilable());
        table.setDisabled(tableDTO.getDisabled());
        return table;
    }

    public List<Table> getAllTable(){
        return tableRepository.findAll();
    }

    public Table createTable(TableDTO tableDTO){
        return tableRepository.save(toEntity(tableDTO));
    }

    public Boolean deleteTable(int idTable){
        try {
            Table table = tableRepository.findByTableId(idTable);
            table.setDisabled(true);
            tableRepository.save(table);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
