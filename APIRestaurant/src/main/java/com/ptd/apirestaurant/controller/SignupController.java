package com.ptd.apirestaurant.controller;


import com.ptd.apirestaurant.dto.AuthenticationResponse;
import com.ptd.apirestaurant.dto.SignupDTO;
import com.ptd.apirestaurant.dto.UserDTO;
import com.ptd.apirestaurant.entity.Employee;
import com.ptd.apirestaurant.service.EmployeeService;
import com.ptd.apirestaurant.service.auth.AuthService;
import com.ptd.apirestaurant.share.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class SignupController {

    @Autowired
    private AuthService authService;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtUtil jwtUtil;

        @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
       UserDTO createdUser = authService.createUser(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/checkusername/")
    ResponseEntity<Boolean> checkEmail(@RequestBody Map<String,String> request){
        Employee employee = employeeService.findFirstByName(request.get("name"));
        if(employee == null)
            return new ResponseEntity<>(false,HttpStatus.OK);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @PostMapping("/token-sign-up")
    ResponseEntity<AuthenticationResponse> generateTokenForSignUp(@RequestBody Employee authenticationDTO){
        UserDetails user  = new org.springframework.security.core.userdetails.User(authenticationDTO.getEmployeeName(),authenticationDTO.getPassword(), new ArrayList<>());
        final String jwt = jwtUtil.generateToken(user.getUsername());
        return new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);
    }

}
