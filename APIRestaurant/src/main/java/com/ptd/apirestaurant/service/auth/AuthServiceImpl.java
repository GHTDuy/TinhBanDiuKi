package com.ptd.apirestaurant.service.auth;


import com.ptd.apirestaurant.dto.SignupDTO;
import com.ptd.apirestaurant.dto.UserDTO;
import com.ptd.apirestaurant.entity.Employee;
import com.ptd.apirestaurant.entity.Shift;
import com.ptd.apirestaurant.reponsitory.EmployeeRepository;
import com.ptd.apirestaurant.reponsitory.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        Employee user = new Employee();
        user.setEmployeeName(signupDTO.getName());
        user.setEmployeeRole(signupDTO.getRole());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        user.setSalary(signupDTO.getSalary());
        Shift shift = shiftRepository.getShiftByShiftId(signupDTO.getShiftID());
        user.setShiftId(shift);
        user.setDisabled(signupDTO.getIs_disable());
        Employee createdUser = employeeRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getEmployeeId());
        userDTO.setName(createdUser.getEmployeeName());
        userDTO.setRole(createdUser.getEmployeeRole());
        userDTO.setSalary(createdUser.getSalary());
        userDTO.setShiftID(createdUser.getShiftId().getShiftId());
        userDTO.setIs_disable(createdUser.getDisabled());
        return userDTO;
    }
}
