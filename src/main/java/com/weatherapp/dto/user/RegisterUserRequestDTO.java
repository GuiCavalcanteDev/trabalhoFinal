package com.weatherapp.dto.user;

import java.time.LocalDate;

public record RegisterUserRequestDTO(String name, String email, String passwordHash) {
}
