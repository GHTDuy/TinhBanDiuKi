package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.TableDTO;
import com.ptd.apirestaurant.entity.Table;
import com.ptd.apirestaurant.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TableController {
    @Autowired
    TableService tableService;

    @PostMapping("/api/table/create")
    public ResponseEntity<Table> createTable(@RequestBody TableDTO tableDTO) {
        return new ResponseEntity<>(tableService.createTable(tableDTO), HttpStatus.OK);
    }

    @GetMapping("/api/table/get-all")
    public ResponseEntity<List<Table>> getAllTable() {
        return new ResponseEntity<>(tableService.getAllTable(), HttpStatus.OK);
    }

    @DeleteMapping("/api/table/delete/{tableID}")
    public ResponseEntity<String> deleteTable(@PathVariable("tableID") int tableID) {
        if (tableService.deleteTable(tableID) == true)
            return new ResponseEntity<>(new SuccessResponse("200", "Success").toString(), HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone("Fail").toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
