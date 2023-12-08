package com.cristian.AplicacionUniversidad.Controller;


import com.cristian.AplicacionUniversidad.Model.Alumno;
import com.cristian.AplicacionUniversidad.Model.Materia;
import com.cristian.AplicacionUniversidad.Service.IAlumnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {
    
    @Autowired
    private IAlumnoService alumnoService;
    
    
    //Endpoint para traer lista completa de alumnos
    @GetMapping("/alumnos")
    public List<Alumno> getAlumnos(){
        return alumnoService.getAlumnos();
    }
    
    //Endpoint para traer un alumno en particular
    @GetMapping("/alumnos/{idAlumno}")
    @ResponseBody
    private ResponseEntity<Alumno> getAlumnoPorCodigo(@PathVariable Long idAlumno){
        Alumno alu = alumnoService.getAlumnoPorCodigo(idAlumno);
        
        if (alu != null){
            return new ResponseEntity<>(alu,HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
   
    
    //Endpoint para crear un nuevo alumno
    @PostMapping("/alumnos/crear")
    public String saveAlumno(@RequestBody Alumno alu){
        alumnoService.saveAlumno(alu);
        return "Alumno guardado.";
    }
    
    //End point para eliminar alumno con determinado código
     @DeleteMapping("/alumnos/eliminar/{idAlumno}")
    public void deleteAlumno(@PathVariable Long idAlumno){
        alumnoService.deleteAlumno(idAlumno);
    }
    
    //Endpoint para modificar entidad alumno
    @PutMapping("/alumnos/editar/{idAlumno}")
    public Alumno editAlumno(@PathVariable Long idAlumno,
            @RequestParam(required = false, name ="idAlumno")Long idNuevo,
            @RequestParam(required = false, name ="nombre")String nombreNuevo,
            @RequestParam(required = false, name ="apellido")String nuevoApellido,
            @RequestParam(required = false, name="dni") String nuevoDni,
            @RequestParam(required = false, name="correo") String correoNuevo,
            @RequestParam(required = false, name="materias") List<Materia> nuevaMateria,
            @RequestParam(required = false, name="estado") boolean nuevoEstado){
        
        alumnoService.editAlumno(idAlumno, idNuevo, nombreNuevo, 
                correoNuevo, nuevoDni, correoNuevo, nuevaMateria, 
                nuevoEstado);
        
        Alumno alu = alumnoService.getAlumnoPorCodigo(idAlumno);
        
        return alu;
    }
    
    
    
}
