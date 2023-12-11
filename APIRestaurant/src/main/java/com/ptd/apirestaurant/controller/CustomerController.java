package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.entity.Customer;
import com.ptd.apirestaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/api/customer/get-all")
    ResponseEntity<List<Customer>> FindAllCustomer(){
        List<Customer> customers = customerService.findAllCustomer();
        return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }
}
