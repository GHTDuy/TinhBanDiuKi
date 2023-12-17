package com.ptd.apirestaurant.controller;

import com.ptd.apirestaurant.dto.HelloResponse;
import com.ptd.apirestaurant.entity.Employee;
import com.ptd.apirestaurant.service.EmployeeService;
import com.ptd.apirestaurant.service.jwt.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hello from JWT Authorization");
    }

    @GetMapping(value = "/current-user",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> currentUser(Principal user){
        Employee u = employeeService.findFirstByName(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }



}
