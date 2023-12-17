package com.ptd.apirestaurant.service.jwt;


import com.ptd.apirestaurant.entity.Employee;
import com.ptd.apirestaurant.reponsitory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //Write Logic to get the user from the DB
        Employee employee = employeeRepository.findFirstByUserName(name);
        if(employee == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new org.springframework.security.core.userdetails.User(employee.getUserName(), employee.getPassword(), new ArrayList<>());
    }
}
