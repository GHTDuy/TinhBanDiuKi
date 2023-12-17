/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptd.apirestaurant.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author DELL
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "Employee.findByEmployeeName", query = "SELECT e FROM Employee e WHERE e.employeeName = :employeeName"),
    @NamedQuery(name = "Employee.findByEmployeeRole", query = "SELECT e FROM Employee e WHERE e.employeeRole = :employeeRole"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic(optional = false)
    @Column(name = "employee_name")
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "employee_role")
    private String employeeRole;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @Column(name = "user_name",unique = true)
    private String userName;

    @Basic(optional = false)
    @Column(name = "salary")
    private int salary;
    @JoinColumn(name = "shift_id", referencedColumnName = "shift_id")
    @ManyToOne(optional = false)
    private Shift shiftId;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }





    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(Integer employeeId, String employeeName, String employeeRole, int salary,String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.salary = salary;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Shift getShiftId() {
        return shiftId;
    }

    public void setShiftId(Shift shiftId) {
        this.shiftId = shiftId;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.Employee[ employeeId=" + employeeId + " ]";
    }
    
}
