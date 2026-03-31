package com.cibertec.daw1_t1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/curso")
public class CursoController {
    @GetMapping("/listar")
    public Object listarCursos(){
        return null;
    }

    @PutMapping("/actualizar/{id}")
    public Object filtrarDocentes(){
        return null;
    }

    @PostMapping("/crear")
    public Object crearDocente(){
        return null;
    }
}
