package com.weatherapp.dto.user;

import org.springframework.http.HttpStatus;

public record UpdateUserResponseDTO(HttpStatus status, String message) {
}
