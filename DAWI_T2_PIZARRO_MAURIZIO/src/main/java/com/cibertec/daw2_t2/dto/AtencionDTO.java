package com.cibertec.daw2_t2.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AtencionDTO {

    private Long id;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String nombreMedico;
    private String apellidoMedico;
    private LocalDate fechaAtencion;
    private String referencia;

}
