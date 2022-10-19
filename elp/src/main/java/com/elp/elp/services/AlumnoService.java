package com.elp.elp.services;

import com.elp.elp.models.Alumno;

import java.util.List;

public interface AlumnoService {
    Alumno save(Alumno alumno);

    Alumno findById(Long id);

    List<Alumno> findAll();

    void delete(Long id);
}
