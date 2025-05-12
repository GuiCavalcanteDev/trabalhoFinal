package com.weatherapp.dto;

public record TokenResponseDTO(String email, String token, boolean status) { }