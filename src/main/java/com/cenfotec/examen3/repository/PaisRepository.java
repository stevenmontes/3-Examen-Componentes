package com.cenfotec.examen3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cenfotec.examen3.domain.DivisionBiologica;
import com.cenfotec.examen3.domain.DivisionPolitica;
import com.cenfotec.examen3.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, String> {

	@Query("select div from DivisionPolitica div, Pais p where p.Sigla = (?1)")
	List<DivisionPolitica> getProvincias(String nSigla);

	@Query("select div from DivisionBiologica div, Pais p where p.Sigla = (?1)")
	List<DivisionBiologica> getAreasBiologicas(String nSigla);

}
