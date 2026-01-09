package com.example.employee.dto;


import com.example.employee.constant.Role;

public record EmployeeResponse(
        Long id,
        String name,
        String email,
        String department,
        Role role
) {}
