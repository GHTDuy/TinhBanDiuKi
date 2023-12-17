package com.ptd.apirestaurant.reponsitory;


import com.ptd.apirestaurant.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findFirstByEmployeeNameAndPassword(String name,String password);
    Employee findByEmployeeId(int employeeID);
    Employee findFirstByUserName(String name);

}
