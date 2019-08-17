package com.cenfotec.examen3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cenfotec.examen3.domain.DivisionPolitica;

public interface DivisionPoliticaRepository extends JpaRepository<DivisionPolitica, String> {

	@Query("select div from DivisionPolitica div where div.Nombre like %?1%")
	List<DivisionPolitica> findAllByNombreContaining(String nombre);

}
