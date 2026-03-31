package com.cibertec.daw1_t1.controller;

import com.cibertec.daw1_t1.model.Curso;
import com.cibertec.daw1_t1.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarCursosZtoA() {
        return ResponseEntity.ok(cursoRepository.findAllByOrderByNombreDesc());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarCurso(@PathVariable Long id, @RequestBody Curso cursoData) {

        if (cursoData.getNombre() == null || cursoData.getNombre().isEmpty() ||
                cursoData.getCarrera() == null || cursoData.getCarrera().isEmpty()) {
            return ResponseEntity.badRequest().body("faltan parametros obligatorios");
        }

        Optional<Curso> cursoExistente = cursoRepository.findById(id);

        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNombre(cursoData.getNombre());
            curso.setCarrera(cursoData.getCarrera());
            curso.setEquivalencia(cursoData.getEquivalencia());

            return ResponseEntity.ok(cursoRepository.save(curso));
        } else {
            return ResponseEntity.badRequest().body("El curso con ID " + id + " no existe.");
        }
    }
}
