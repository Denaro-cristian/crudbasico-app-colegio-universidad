package com.cristian.AplicacionUniversidad.Repository;

import com.cristian.AplicacionUniversidad.Model.Materia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long> {
    
}
