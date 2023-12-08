package com.cristian.AplicacionUniversidad.Repository;

import com.cristian.AplicacionUniversidad.Model.Alumno;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
    
  //  List<Alumno> getALumnosDeMateria(String nombreMateria);
    
}
