package com.example.employee.service.impl;

import com.example.employee.dto.AuthRequest;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.security.JwtUtil;
import com.example.employee.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository repository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            EmployeeRepository repository,
            PasswordEncoder encoder,
            JwtUtil jwtUtil
    ) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(AuthRequest request) {
        Employee emp = repository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!encoder.matches(request.password(), emp.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(emp.getEmail(), String.valueOf(emp.getRole()));
    }
}

