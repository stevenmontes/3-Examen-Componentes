package com.cenfotec.examen3.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="division_biologica")
public class DivisionBiologica {
	@Id
	@Column(name="Nombre")
	private String Nombre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_Pais")
	private Pais Pais;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="politico_x_biologico", joinColumns = @JoinColumn(name="Id_Biologico", referencedColumnName = "Nombre"), 
	inverseJoinColumns = @JoinColumn(name="Id_Politico", referencedColumnName = "Nombre"))
	private Set<DivisionPolitica> Provincias;
	
	public DivisionBiologica(String nombre, com.cenfotec.examen3.domain.Pais pais) {
		super();
		Nombre = nombre;
		Pais = pais;
	}

	public DivisionBiologica() {
		super();
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Pais getPais() {
		return Pais;
	}

	public void setPais(Pais pais) {
		Pais = pais;
	}

	public Set<DivisionPolitica> getProvincias() {
		return Provincias;
	}

	public void setProvincias(Set<DivisionPolitica> provincias) {
		Provincias = provincias;
	}
	
}
