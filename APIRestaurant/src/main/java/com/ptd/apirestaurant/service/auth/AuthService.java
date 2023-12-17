package com.ptd.apirestaurant.service.auth;


import com.ptd.apirestaurant.dto.SignupDTO;
import com.ptd.apirestaurant.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
