package com.cenfotec.examen3.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	@Id
	@Column(name = "Sigla")
	private String Sigla;
	@Column(name = "Pais")
	private String Nombre;
	@Column(name = "Superficie_Terrestre")
	private int SuperficieTerrestre;
	@Column(name = "Superficie_Maritima")
	private int SuperficieMaritima;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_Continente", referencedColumnName = "Nombre")
	private Continente continente;

	@OneToMany(mappedBy = "Pais")
	private List<DivisionPolitica> Provincias = new ArrayList<DivisionPolitica>();

	@OneToMany(mappedBy = "Pais")
	private List<DivisionBiologica> AreasBiologicas = new ArrayList<DivisionBiologica>();

	@ManyToMany(mappedBy = "Paises")
	private List<Animal> Animales = new ArrayList<Animal>();
	
	public Pais(String sigla, String nombre, int superficieTerrestre, int superficieMaritima, Continente nContinente) {
		super();
		Sigla = sigla;
		Nombre = nombre;
		SuperficieTerrestre = superficieTerrestre;
		SuperficieMaritima = superficieMaritima;
		continente = nContinente;
	}

	public Pais() {
		super();
	}

	public String getSigla() {
		return Sigla;
	}

	public void setSigla(String sigla) {
		Sigla = sigla;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getSuperficieTerrestre() {
		return SuperficieTerrestre;
	}

	public void setSuperficieTerrestre(int superficieTerrestre) {
		SuperficieTerrestre = superficieTerrestre;
	}

	public int getSuperficieMaritima() {
		return SuperficieMaritima;
	}

	public void setSuperficieMaritima(int superficieMaritima) {
		SuperficieMaritima = superficieMaritima;
	}

	public Continente getContinenteActual() {
		return continente;
	}

	public void setContinenteActual(Continente continenteActual) {
		continente = continenteActual;
	}
}
