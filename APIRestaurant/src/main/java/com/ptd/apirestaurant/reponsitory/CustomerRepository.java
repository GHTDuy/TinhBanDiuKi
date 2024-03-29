package com.ptd.apirestaurant.reponsitory;


import com.ptd.apirestaurant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAll();
    Customer findByCustomerId(int customerID);
    Customer getCustomerByCustomerId(int id);
}
