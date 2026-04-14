package com.cibertec.daw2_t2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "atencion")
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombrePaciente;

    @Column(nullable = false)
    private String apellidoPaciente;

    @Column(nullable = false)
    private String nombreMedico;

    @Column(nullable = false)
    private String apellidoMedico;

    @Column(nullable = false)
    private LocalDate fechaAtencion;

    private String referencia;

}