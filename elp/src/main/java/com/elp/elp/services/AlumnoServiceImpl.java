package com.elp.elp.services;

import com.elp.elp.dao.AlumnoDao;
import com.elp.elp.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService{
    @Autowired
    private AlumnoDao alumnoDao;


    @Override
    public Alumno save(Alumno alumno) {
        return alumnoDao.save(alumno);
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoDao.findById(id).orElse(null);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoDao.findAll();
    }

    @Override
    public void delete(Long id) {
        alumnoDao.deleteById(id);

    }
}
