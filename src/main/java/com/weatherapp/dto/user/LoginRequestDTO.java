package com.weatherapp.dto.user;

public record LoginRequestDTO(String email, String passwordHash) {
}
