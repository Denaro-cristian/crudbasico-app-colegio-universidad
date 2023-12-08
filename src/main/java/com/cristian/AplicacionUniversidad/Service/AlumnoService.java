package com.cristian.AplicacionUniversidad.Service;

import com.cristian.AplicacionUniversidad.Model.Alumno;
import com.cristian.AplicacionUniversidad.Model.Materia;
import com.cristian.AplicacionUniversidad.Repository.AlumnoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService implements IAlumnoService{
    
    @Autowired
    private AlumnoRepository alumnoRepo;

    @Override
    public List<Alumno> getAlumnos() {
        List<Alumno> listaAlumnos = (List<Alumno>) alumnoRepo.findAll();
        return listaAlumnos;
        }

    @Override
    public Alumno getAlumnoPorCodigo(Long idAlumno) {
        return alumnoRepo.findById(idAlumno).orElse(null);
    }

    @Override
    public String saveAlumno(Alumno alu) {
        alumnoRepo.save(alu);
        return "Alumno guardado.";
    }

    @Override
    public void deleteAlumno(Long idAlumno) {
        alumnoRepo.deleteById(idAlumno);
    }

    @Override
    public void editAlumno(Long idALumno, Long idNuevo, String nombreNuevo, 
            String apellidoNuevo, String nuevoDni, String correoNuevo, List<Materia> nuevaMateria, 
            boolean nuevoEstado) {
        Alumno alu = this.getAlumnoPorCodigo(idALumno);
        alu.setIdAlumno(idNuevo);
        alu.setNombre(nombreNuevo);
        alu.setApellido(apellidoNuevo);
        alu.setDni(nuevoDni);
        alu.setCorreoElec(correoNuevo);
        alu.setMateria(nuevaMateria);
        alu.setActivo(nuevoEstado);
        
        this.saveAlumno(alu);
    }
}
