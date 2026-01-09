package com.example.employee.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthResponse(

        @NotBlank
        String token

) {}
