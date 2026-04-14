package com.cibertec.daw2_t2.controller;

import com.cibertec.daw2_t2.dto.AtencionDTO;
import com.cibertec.daw2_t2.model.Atencion;
import com.cibertec.daw2_t2.repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atenciones")
public class AtencionController {

    @Autowired
    private AtencionRepository repo;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/historial")
    public ResponseEntity<?> historial(
            @RequestParam String nombrePaciente,
            @RequestParam String apellidoPaciente) {

        if (nombrePaciente == null || apellidoPaciente == null) {
            return ResponseEntity.badRequest().body("Faltan parametros");
        }

        List<Atencion> lista = repo
                .findByNombrePacienteAndApellidoPacienteOrderByFechaAtencionDesc(
                        nombrePaciente, apellidoPaciente);

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay historial");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody AtencionDTO dto) {

        if (dto.getNombrePaciente() == null ||
                dto.getApellidoPaciente() == null ||
                dto.getNombreMedico() == null ||
                dto.getApellidoMedico() == null ||
                dto.getFechaAtencion() == null) {

            return ResponseEntity.badRequest().body("faltan campos");
        }

        Atencion a = new Atencion();
        a.setNombrePaciente(dto.getNombrePaciente());
        a.setApellidoPaciente(dto.getApellidoPaciente());
        a.setNombreMedico(dto.getNombreMedico());
        a.setApellidoMedico(dto.getApellidoMedico());
        a.setFechaAtencion(dto.getFechaAtencion());
        a.setReferencia(dto.getReferencia());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repo.save(a));
    }

    @GetMapping("/rango")
    public ResponseEntity<?> rango(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {

        List<Atencion> lista = repo.findByFechaAtencionBetween(fechaInicio, fechaFin);

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no hay datos");
        }

        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody AtencionDTO dto) {

        Optional<Atencion> existente = repo.findById(id);

        if (!existente.isPresent()) {
            return ResponseEntity.badRequest().body("No existe");
        }

        Atencion a = existente.get();
        a.setNombrePaciente(dto.getNombrePaciente());
        a.setApellidoPaciente(dto.getApellidoPaciente());
        a.setNombreMedico(dto.getNombreMedico());
        a.setApellidoMedico(dto.getApellidoMedico());
        a.setFechaAtencion(dto.getFechaAtencion());
        a.setReferencia(dto.getReferencia());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repo.save(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        Optional<Atencion> existente = repo.findById(id);

        if (!existente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("noo existe");
        }

        repo.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
