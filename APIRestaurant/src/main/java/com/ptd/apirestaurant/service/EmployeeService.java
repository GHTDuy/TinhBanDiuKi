package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.entity.Employee;
import com.ptd.apirestaurant.entity.Login;
import com.ptd.apirestaurant.entity.Shift;
import com.ptd.apirestaurant.reponsitory.EmployeeRepository;
import com.ptd.apirestaurant.reponsitory.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.text.Normalizer;
import java.util.regex.Pattern;

@Service
public class EmployeeService {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ShiftRepository shiftRepository;

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
    }


    public Employee LoginEmployee(Login login){
        String password = passwordEncoder.encode(login.getPassword());
        Employee employee = employeeRepository.findFirstByEmployeeNameAndPassword(login.getName(), password);
        return employee;
    }

    public Employee findFirstByName(String name){
        return employeeRepository.findFirstByUserName(name);
    }
    public Employee createEmployee(Employee employee){
        String password = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(password);
        Employee e = employeeRepository.save(employee);
        String lastName = e.getEmployeeName().split(" ")[e.getEmployeeName().split(" ").length-1];
        String userName = removeAccent(lastName)+Integer.toString(e.getEmployeeId());
        e.setUserName(userName);
        return employeeRepository.save(e);
    }
    public String assignShift(int employeeID,int shiftID){
        Employee employee = employeeRepository.findByEmployeeId(employeeID);
        if(employee == null) return "Can't find the employee";
        if(employee.getEmployeeRole() != "WAITER") return "Can't assign the employee who is not a waiter";
        Shift shift = shiftRepository.getShiftByShiftId(shiftID);
        if(shift ==null) return "Shift is invalid";
        try {
            employee.setShiftId(shift);
            employeeRepository.save(employee);
            return "success";
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
}
