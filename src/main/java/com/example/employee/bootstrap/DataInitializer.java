package com.example.employee.bootstrap;

import com.example.employee.constant.Role;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(EmployeeRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            Employee admin = new Employee();
            admin.setName("Admin");
            admin.setEmail("admin@example.com");
            admin.setDepartment("IT");
            admin.setRole(Role.ROLE_ADMIN);
            admin.setPassword(passwordEncoder.encode("admin123"));
            repository.save(admin);
            System.out.println("Created default admin: admin@example.com / admin123");
        }
    }
}

