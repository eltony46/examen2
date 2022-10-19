package com.elp.elp.controllers;

import com.elp.elp.models.Alumno;
import com.elp.elp.models.Pension;
import com.elp.elp.services.AlumnoService;
import com.elp.elp.services.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private PensionService pensionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Alumno>> listarAlumno(){
        return new ResponseEntity<>(alumnoService.findAll(), HttpStatus.OK);
    }
    @GetMapping({"/pensiones"})
    public ResponseEntity<List<Pension>> listarPension() {
        return new ResponseEntity(this.pensionService.findAll(), HttpStatus.OK);
    }
    @PostMapping({"/crear"})
    public ResponseEntity<Alumno> listarAlumno(@RequestBody Alumno alumno) {
        return new ResponseEntity(this.alumnoService.save(alumno), HttpStatus.CREATED);
    }
    @PutMapping({"/actualizar/{id}"})
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno alumnoEncontrado = this.alumnoService.findById(id);
        if (alumnoEncontrado == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            try {
                alumnoEncontrado.setNombre(alumno.getNombre());
                alumnoEncontrado.setApellido(alumno.getApellido());
                alumnoEncontrado.setDNI(alumno.getDNI());
                alumnoEncontrado.setCiclo(alumno.getCiclo());
                alumnoEncontrado.setFecha_nacimiento(alumno.getFecha_nacimiento());
                alumnoEncontrado.setDireccion(alumno.getDireccion());
                alumnoEncontrado.setTelefono(alumno.getTelefono());
                return new ResponseEntity(this.alumnoService.save(alumnoEncontrado), HttpStatus.CREATED);
            } catch (DataAccessException var5) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @DeleteMapping({"/eliminar/{id}"})
    public ResponseEntity<?> actualizarAlumno(@PathVariable Long id) {
        this.alumnoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }




}
