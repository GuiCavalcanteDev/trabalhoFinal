package com.weatherapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cidade")
public class CidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String pais;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<ConsultaClima> consultas;

}
