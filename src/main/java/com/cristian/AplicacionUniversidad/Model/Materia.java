package com.cristian.AplicacionUniversidad.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="materia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materia {
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMateria;
	
	@Column(name="nombre")
	private String nombreMateria;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="cupo")
	private int cupo;
	
	@Column(name="horario")
	private String horario;
        
        @ManyToMany
        @JoinTable(name="materia_alumno",
                   joinColumns= {@JoinColumn(name = "materiaId")},
                   inverseJoinColumns = {@JoinColumn(name = "alumnoId")}
        )
        private List<Alumno> alumno;
    
}
