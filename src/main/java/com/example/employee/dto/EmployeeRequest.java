package com.example.employee.dto;


import com.example.employee.constant.Role;

public record EmployeeRequest(
        String name,
        String email,
        String department,
        Role role,
        String password
) {}
