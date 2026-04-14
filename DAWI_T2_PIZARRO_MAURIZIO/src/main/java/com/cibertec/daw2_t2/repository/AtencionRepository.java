package com.cibertec.daw2_t2.repository;

import com.cibertec.daw2_t2.model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    List<Atencion> findByNombrePacienteAndApellidoPacienteOrderByFechaAtencionDesc(
            String nombre, String apellido);

    List<Atencion> findByFechaAtencionBetween(LocalDate inicio, LocalDate fin);
}
