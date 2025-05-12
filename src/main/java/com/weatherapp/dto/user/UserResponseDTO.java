package com.weatherapp.dto.user;

import com.weatherapp.model.user.UserPermission;

public record UserResponseDTO(Long id, String name, String email, String passwordHash, UserPermission role) {
}
