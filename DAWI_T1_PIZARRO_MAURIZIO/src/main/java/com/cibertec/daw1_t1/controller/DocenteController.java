package com.cibertec.daw1_t1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/docente")
public class DocenteController {

    @GetMapping("/listar")
    public Object listarDocente(){
        return null;
    }

    @GetMapping("/filtrar")
    public Object filtrarDocentes(){
        return null;
    }

    @PostMapping("/crear")
    public Object crearDocente(){
        return null;
    }
}
