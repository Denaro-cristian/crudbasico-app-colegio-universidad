package com.cristian.AplicacionUniversidad.Service;

import com.cristian.AplicacionUniversidad.Model.Alumno;
import com.cristian.AplicacionUniversidad.Model.Materia;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IAlumnoService {
    
    
    //método para traer lista completa de alumnos
    public List<Alumno> getAlumnos();
    
    //método para traer un alumno en particular
    public Alumno getAlumnoPorCodigo(Long idAlumno);
    
    
    //método para crear nuevo alumno
    public String saveAlumno(Alumno alu);
    
    //método para eliminar un alumno
    public void deleteAlumno(Long idAlumno);
    
    //método para modificar datos de alumno
    public void editAlumno(Long idALumno, Long idNuevo, String nombreNuevo,
                            String apellidoNuevo, String nuevoDni, 
                            String correoNuevo, List<Materia> nuevaMateria, 
                            boolean nuevoEstado);
    
    
    
    
    
}
