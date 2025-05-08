package com.weatherapp.repository;

import com.weatherapp.model.ConsultaClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaClimaRepository extends JpaRepository<ConsultaClima, Long> {
    List<ConsultaClima> findByUsuarioId(Long usuarioId);
}
