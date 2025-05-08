package com.weatherapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consulta_clima")
public class ConsultaClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatura;
    private String descricao;
    private LocalDateTime dataConsulta;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private CidadeModel cidade;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel usuario;

}