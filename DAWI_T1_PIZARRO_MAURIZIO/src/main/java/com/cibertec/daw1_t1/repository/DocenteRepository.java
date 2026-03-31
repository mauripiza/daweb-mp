package com.cibertec.daw1_t1.repository;

import com.cibertec.daw1_t1.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    List<Docente> findByApellidosStartingWith(String letras);
}
