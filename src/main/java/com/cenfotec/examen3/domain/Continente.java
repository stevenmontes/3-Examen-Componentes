package com.cenfotec.examen3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="continente")
public class Continente {
	@Id
	@Column(name = "Nombre")
	private String Nombre;

	public Continente(String nombre, Pais nPais) {
		super();
		Nombre = nombre;
	}

	public Continente() {
		super();
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}	
}
