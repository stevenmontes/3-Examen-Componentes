package com.cenfotec.examen3.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.domain.Animal;
import com.cenfotec.examen3.repository.AnimalRepository;

@RestController
@RequestMapping("animal")
public class AnimalController {
	@Autowired
	private AnimalRepository repo;

	@PostMapping
	public Animal Create(@Valid @RequestBody Animal nnAnimal) {
		return repo.save(nnAnimal);
	}

	@GetMapping
	public List<Animal> GetAll(@RequestParam(value = "nombre", required = false) String nNombre) {
		if(nNombre != null) {
			return repo.findAllByNombreContaining(nNombre);
		}
		
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Animal> Get(@PathVariable(value = "id") int id) {
		return repo.findById(id);
	}

	@PutMapping
	public Animal Update(@Valid @RequestBody Animal nnAnimal) {
		return repo.save(nnAnimal);
	}

	@DeleteMapping("/{id}")
	public Optional<Animal> Delete(@PathVariable(value = "id") int id) {
		Optional<Animal> nAnimal = repo.findById(id);

		if (nAnimal != null) {
			repo.deleteById(id);
		}

		return nAnimal;
	}
}
