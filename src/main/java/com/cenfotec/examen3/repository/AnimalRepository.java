package com.cenfotec.examen3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cenfotec.examen3.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{

	@Query("select a from Animal a where a.NombrePopular like %?1%")
	List<Animal> findAllByNombreContaining(String nNombre);

}
