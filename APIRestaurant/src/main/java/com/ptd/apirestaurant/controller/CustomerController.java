package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.Reponse.FailureRepsone;
import com.ptd.apirestaurant.Reponse.SuccessResponse;
import com.ptd.apirestaurant.dto.CustomerDTO;
import com.ptd.apirestaurant.entity.Customer;
import com.ptd.apirestaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/api/customer/get-all")
    ResponseEntity<List<Customer>> FindAllCustomer(){
        List<Customer> customers = customerService.findAllCustomer();
        return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }
    @PostMapping("/api/customer/create")
    ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.createOrUpdateCustomer(customerDTO),HttpStatus.OK);
    }

    @DeleteMapping("/api/customer/delete/{customerID}")
    ResponseEntity<String> deleteCustomer(@PathVariable("customerID") int customerID){
        if(customerService.deleteCustomer(customerID) == true)
            return new ResponseEntity<>( new SuccessResponse("200","Success").toString(),HttpStatus.OK);
        return new ResponseEntity<>(new FailureRepsone("Fail").toString(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
