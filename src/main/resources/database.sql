CREATE DATABASE weatherapp;

USE weatherapp;

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE cidade (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL
);

CREATE TABLE consulta_clima (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    temperatura DOUBLE,
    descricao VARCHAR(255),
    data_consulta DATETIME,
    usuario_id BIGINT,
    cidade_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (cidade_id) REFERENCES cidade(id)
);
