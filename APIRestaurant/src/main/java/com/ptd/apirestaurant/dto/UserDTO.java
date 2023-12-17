package com.ptd.apirestaurant.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String password;
    private String role;
    private Integer salary;
    private Integer shiftID;
    private Boolean is_disable;

}
