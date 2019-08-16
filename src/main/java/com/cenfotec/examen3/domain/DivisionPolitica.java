package com.cenfotec.examen3.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "division_politica")
public class DivisionPolitica {
	@Id
	@Column(name = "nombre")
	private String Nombre;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_Pais")
	private Pais Pais;

	public DivisionPolitica(String nombre, Pais pais) {
		super();
		Nombre = nombre;
		Pais = pais;
	}

	public DivisionPolitica() {
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

}
