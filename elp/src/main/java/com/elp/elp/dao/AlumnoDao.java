package com.elp.elp.dao;

import com.elp.elp.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoDao extends JpaRepository<Alumno, Long>{
}
