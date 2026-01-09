package com.example.employee.service;

import com.example.employee.dto.AuthRequest;

public interface AuthService {
    String login(AuthRequest request);
}
