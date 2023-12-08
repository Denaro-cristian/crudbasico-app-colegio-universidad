package com.cristian.AplicacionUniversidad.Service;

import com.cristian.AplicacionUniversidad.Model.Alumno;
import com.cristian.AplicacionUniversidad.Model.Materia;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IMateriaService {
    
    //método para traer lista completa de materias
    public List<Materia> getMaterias();
    
    //método para traer materia por código
    public Materia getMateriaPorCodigo(Long idMateria);
    
    //método para crear una nueva materia
    public String saveMateria(Materia mate);
    
    //método para eliminar una materia
    public void deleteMateria(Long idMateria);
    
    //método para editar entidad materia
    public void editMateria(Long idMateria, Long idMateNuevo, 
                            String nombreMateNuevo, String nuevaDescrip,
                            int nuevoCupo, String nuevoHorario, 
                            List<Alumno> nuevoAlumno);
                            
           
            
    
}
