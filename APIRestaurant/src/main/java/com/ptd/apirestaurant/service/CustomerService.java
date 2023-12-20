package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.dto.CustomerDTO;
import com.ptd.apirestaurant.entity.Customer;
import com.ptd.apirestaurant.reponsitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    private Customer toEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerName(customer.getCustomerName());
        customer.setCustomerPhone(customer.getCustomerPhone());
        customer.setDisabled(customer.getDisabled());
        return customer;
    }
    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }
    public Customer createOrUpdateCustomer(CustomerDTO customerDTO){
        return customerRepository.save(this.toEntity(customerDTO));
    }
    public Boolean deleteCustomer(int idCustomer){
        try {
            Customer c = customerRepository.findByCustomerId(idCustomer);
            c.setDisabled(true);
            customerRepository.save(c);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
