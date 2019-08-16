package com.cenfotec.examen3.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Nombre_Popular")
	private String NombrePopular;
	@Column(name = "Nombre_Cientifico")
	private String NombreCientifico;
	@Column(name = "Peligro_Extincion")
	private boolean PeligroExtincion;
	@Column(name = "Poblacion")
	private int Poblacion;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pais_x_animal", joinColumns = @JoinColumn(name = "Id_Animal", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Id_Pais", referencedColumnName = "Sigla"))
	private Set<Pais> Paises = new HashSet<>();

	public Animal(String nombrePopular, String nombreCientifico, boolean peligroExtincion, int poblacion, Pais... nPaises) {
		super();
		NombrePopular = nombrePopular;
		NombreCientifico = nombreCientifico;
		PeligroExtincion = peligroExtincion;
		Poblacion = poblacion;
	}

	public Animal() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombrePopular() {
		return NombrePopular;
	}

	public void setNombrePopular(String nombrePopular) {
		NombrePopular = nombrePopular;
	}

	public String getNombreCientifico() {
		return NombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		NombreCientifico = nombreCientifico;
	}

	public boolean isPeligroExtincion() {
		return PeligroExtincion;
	}

	public void setPeligroExtincion(boolean peligroExtincion) {
		PeligroExtincion = peligroExtincion;
	}

	public int getPoblacion() {
		return Poblacion;
	}

	public void setPoblacion(int poblacion) {
		Poblacion = poblacion;
	}

	public Set<Pais> getPaises() {
		return Paises;
	}

	public void setPaises(Set<Pais> paises) {
		Paises = paises;
	}

}
