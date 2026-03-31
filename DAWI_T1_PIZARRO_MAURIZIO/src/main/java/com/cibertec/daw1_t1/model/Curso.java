package com.cibertec.daw1_t1.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//estoy usando lombok para el setter y el getter profe
@Setter
@Getter
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String carrera;

    private String equivalencia;

}

