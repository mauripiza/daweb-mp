package com.cibertec.daw1_t1.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;



//aca tmb lombok
@Setter
@Getter
@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombres;

    @NotBlank
    @Column(nullable = false)
    private String apellidos;

    @NotBlank
    @Column(nullable = false)
    private String carrera;

    @NotBlank
    @Column(nullable = false)
    private String facultad;

    private String especializacion;

}
