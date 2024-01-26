package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.ShiftDTO;
import com.ptd.apirestaurant.entity.Shift;
import com.ptd.apirestaurant.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ShiftController {
    @Autowired
    ShiftService shiftService;

    @PostMapping("/api/shift/create")
    public ResponseEntity<Shift> createShift(@RequestBody ShiftDTO shiftDTO) {
        return new ResponseEntity<>(shiftService.createShift(shiftDTO), HttpStatus.OK);
    }

    @GetMapping("/api/shift/get-all")
    public ResponseEntity<List<Shift>> getAllShift() {
        return new ResponseEntity<>(shiftService.getAllShif(), HttpStatus.OK);
    }

    @DeleteMapping("/api/shift/delete/{tableID}")
    public ResponseEntity<String> deleteShift(@PathVariable("tableID") int shiftId) {
        if (shiftService.deleteShift(shiftId) == true)
            return new ResponseEntity<>(new SuccessResponse("200", "Success").toString(), HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone("Fail").toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
