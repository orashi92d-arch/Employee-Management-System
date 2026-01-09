package com.example.employee.mapper;

import com.example.employee.dto.EmployeeRequest;
import com.example.employee.dto.EmployeeResponse;
import com.example.employee.entity.Employee;

public final class EmployeeMapper {

    private EmployeeMapper() {
        // prevent instantiation
    }

    public static Employee toEntity(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.name());
        employee.setEmail(request.email());
        employee.setDepartment(request.department());
        employee.setRole(request.role());
        // password is handled in service (encoded), NOT here
        return employee;
    }

    public static EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getRole()
        );
    }
}
