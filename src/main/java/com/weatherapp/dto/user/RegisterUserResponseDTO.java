package com.weatherapp.dto.user;

import org.springframework.http.HttpStatus;

public record RegisterUserResponseDTO(HttpStatus status, String message) {}
