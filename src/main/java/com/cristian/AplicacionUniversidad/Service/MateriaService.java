package com.cristian.AplicacionUniversidad.Service;

import com.cristian.AplicacionUniversidad.Model.Alumno;
import com.cristian.AplicacionUniversidad.Model.Materia;
import com.cristian.AplicacionUniversidad.Repository.MateriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService implements IMateriaService{
    
    @Autowired
    public MateriaRepository materiaRepo;

    @Override
    public List<Materia> getMaterias() {
        List<Materia> listaMaterias = (List<Materia>) materiaRepo.findAll();
        return listaMaterias;
    }

    @Override
    public Materia getMateriaPorCodigo(Long idMateria) {
        return materiaRepo.findById(idMateria).orElse(null);
    }

    @Override
    public String saveMateria(Materia mate) {
        materiaRepo.save(mate);
        return "Materia creada.";
    }

    @Override
    public void deleteMateria(Long idMateria) {
        materiaRepo.deleteById(idMateria);
    }

    @Override
    public void editMateria(Long idMateria, Long idMateNuevo, 
                            String nombreMateNuevo, String nuevaDescrip, 
                            int nuevoCupo,String nuevoHorario, 
                            List<Alumno> nuevoAlumno) {
        Materia mate = this.getMateriaPorCodigo(idMateria);
        mate.setIdMateria(idMateNuevo);
        mate.setNombreMateria(nombreMateNuevo);
        mate.setDescripcion(nuevaDescrip);
        mate.setCupo(nuevoCupo);
        mate.setAlumno(nuevoAlumno);
        
        this.saveMateria(mate);
    }   
    
}
