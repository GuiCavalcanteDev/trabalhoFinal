package com.weatherapp.repository;

import com.weatherapp.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {
    Optional<CidadeModel> findByNome(String nome);
}
