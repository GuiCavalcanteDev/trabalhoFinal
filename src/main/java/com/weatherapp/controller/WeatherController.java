package com.weatherapp.controller;

import com.weatherapp.model.ConsultaClima;
import com.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clima")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{cidade}")
    public ResponseEntity<ConsultaClima> getClima(@PathVariable String cidade) {
        try {
            ConsultaClima clima = weatherService.buscarClimaPorCidade(cidade);
            return ResponseEntity.ok(clima);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}