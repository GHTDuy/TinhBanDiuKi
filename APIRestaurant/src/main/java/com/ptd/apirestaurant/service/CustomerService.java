package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.entity.Customer;
import com.ptd.apirestaurant.reponsitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }
}
