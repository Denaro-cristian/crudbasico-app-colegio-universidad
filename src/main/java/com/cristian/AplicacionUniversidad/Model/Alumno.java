/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name="alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
        
    
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long idAlumno;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
        
        @Column(name="dni")
        private String dni;
	
	@Column(name="correo") 
	private String correoElec;
        
        @ManyToMany
        @JoinTable(name="materia_alumno",
                   joinColumns= {@JoinColumn(name = "materiaId")},
                   inverseJoinColumns = {@JoinColumn(name = "alumnoId")}
        )
        private List<Materia> materia;
       
	@Column(name="activo")
	private boolean activo; 
        
}
