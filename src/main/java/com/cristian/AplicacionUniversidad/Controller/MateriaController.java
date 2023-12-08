package com.cristian.AplicacionUniversidad.Controller;

import com.cristian.AplicacionUniversidad.Model.Alumno;
import com.cristian.AplicacionUniversidad.Model.Materia;
import com.cristian.AplicacionUniversidad.Service.MateriaService;
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
public class MateriaController {
    
    @Autowired
    private MateriaService materiaService;
    
    @GetMapping("/materias")
    public List<Materia> getMaterias(){
        return materiaService.getMaterias();
    }
    
    @GetMapping("/materias/{idMateria}")
    @ResponseBody
    public ResponseEntity<Materia> getMateriaPorCodigo(@PathVariable Long idMateria){
        Materia mate = materiaService.getMateriaPorCodigo(idMateria);
        
        if(mate != null){
            return new ResponseEntity<>(mate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/materias/crear")
    public String saveMateria(@RequestBody Materia mate){
        materiaService.saveMateria(mate);
        return "Materia creada.";
    }
    
    @DeleteMapping("/materias/eliminar/{idMateria}")
    public void deleteMateria(Long idMateria){
        materiaService.deleteMateria(idMateria);
    }
    
    @PutMapping("/materias/editar/{idMateria}")
    public Materia editMateria(@PathVariable Long idMateria,
            @RequestParam(required = false, name="idMateria") Long idMateNuevo,
            @RequestParam(required = false, name="nombre") String nombreMateNuevo,
            @RequestParam(required = false, name="descripcion") String nuevaDescrip,
            @RequestParam(required = false, name="cupo") int nuevoCupo,
            @RequestParam(required = false, name="alumno")List<Alumno> nuevoAlumno){
        
        materiaService.editMateria(idMateria, idMateNuevo, nombreMateNuevo, 
                nuevaDescrip, nuevoCupo, nuevaDescrip, nuevoAlumno);
        
        Materia mate = materiaService.getMateriaPorCodigo(idMateria);
        
        return mate;
        
    }
    
    
}
