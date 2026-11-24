package com.example.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * Punto de entrada del sistema de gestión de préstamos.
 * Arquitectura en capas: domain (modelo y puertos), infrastructure (adaptadores y entidades JPA).
 * El escaneo de componentes y de repositorios cubre los paquetes de cada capa.
 */
@SpringBootApplication(scanBasePackages = {"com.example.reto", "domain", "infrastructure"})
@EnableJpaRepositories(basePackages = "infrastructure")
@EntityScan(basePackages = "infrastructure.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}