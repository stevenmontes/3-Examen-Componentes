package com.cenfotec.examen3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen3.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{

}
