package com.cibertec.daw1_t1.controller;

import com.cibertec.daw1_t1.model.Docente;
import com.cibertec.daw1_t1.repository.DocenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping("/listar")
    public ResponseEntity<?> listarDocente(){
        return ResponseEntity.ok(docenteRepository.findAll());
    }

    @GetMapping("/filtrar")
    public ResponseEntity<?> filtrarDocentes(@RequestParam String letras){

        List<Docente> lista = docenteRepository.findByApellidosStartingWith(letras);

        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no lo encontre");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearDocente(@RequestBody Docente docente){
        if(docente.getNombres() == null || docente.getNombres().isEmpty() ||
                docente.getApellidos() == null || docente.getApellidos().isEmpty() ||
                docente.getCarrera() == null || docente.getCarrera().isEmpty() ||
                docente.getFacultad() == null || docente.getFacultad().isEmpty()){

            return ResponseEntity.badRequest().body("faltan parametros obligatorios");
        }

        return ResponseEntity.ok(docenteRepository.save(docente));
    }
}
