package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.EmployeeDTO;
import com.ptd.apirestaurant.entity.Employee;
import com.ptd.apirestaurant.entity.Login;
import com.ptd.apirestaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/api/login")
    public ResponseEntity<Employee> login(@RequestBody Login login){
        return new ResponseEntity<>(employeeService.LoginEmployee(login), HttpStatus.OK);
    }

    @PostMapping("/api/employee/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/api/employee/assign-shift")
    public ResponseEntity<String> assignEmployeeShift(@RequestBody Map<String, String> req){
        int emloyeeId = Integer.parseInt(req.get("idEmployee"));
        int shiftId = Integer.parseInt(req.get("idShift"));
        String res = employeeService.assignShift(emloyeeId,shiftId);
        if(res == "succes")
            return new ResponseEntity<>(new SuccessResponse("200","Success").toString(),HttpStatus.OK);
        else
            return new ResponseEntity<>(new FailureRepsone(res).toString(),HttpStatus.OK);
    }
}
