package com.cenfotec.examen3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cenfotec.examen3.domain.DivisionBiologica;

public interface DivisionBiologicaRepository extends JpaRepository<DivisionBiologica, String> {

	@Query("select div from DivisionBiologica div where div.Nombre like %?1%")
	List<DivisionBiologica> findAllByNombreContaining(String nombre);

}
