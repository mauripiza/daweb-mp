package com.cibertec.daw1_t1.repository;

import com.cibertec.daw1_t1.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findAllByOrderByNombreDesc();
}
