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
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.domain.DivisionBiologica;
import com.cenfotec.examen3.repository.DivisionBiologicaRepository;

@RestController
@RequestMapping("division_biologica")
public class DivisionBiologicaController {
	@Autowired
	private DivisionBiologicaRepository repo;

	@PostMapping
	public DivisionBiologica Create(@Valid @RequestBody DivisionBiologica nDivBiologica) {
		return repo.save(nDivBiologica);
	}

	@GetMapping
	public List<DivisionBiologica> GetAll() {
		return repo.findAll();
	}

	@GetMapping("/{nombre}")
	public Optional<DivisionBiologica> Get(@PathVariable(value = "nombre") String nombre) {
		return repo.findById(nombre);
	}

	@PutMapping
	public DivisionBiologica Update(@Valid @RequestBody DivisionBiologica nDivBiologica) {
		return repo.save(nDivBiologica);
	}

	@DeleteMapping("/{nombre}")
	public Optional<DivisionBiologica> Delete(@PathVariable(value = "nombre") String nombre) {
		Optional<DivisionBiologica> divBiologica = repo.findById(nombre);

		if (divBiologica != null) {
			repo.deleteById(nombre);
		}

		return divBiologica;
	}
}
