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

import com.cenfotec.examen3.domain.Continente;
import com.cenfotec.examen3.repository.ContinenteRepository;

@RestController
@RequestMapping("continente")
public class ContinenteController {

	@Autowired
	private ContinenteRepository repo;

	@PostMapping
	public Continente Create(@Valid @RequestBody Continente nContinente) {
		return repo.save(nContinente);
	}

	@GetMapping
	public List<Continente> GetAll() {
		return repo.findAll();
	}

	@GetMapping("/{nombre}")
	public Optional<Continente> Get(@PathVariable(value = "nombre") String nombre) {
		return repo.findById(nombre);
	}

	@PutMapping
	public Continente Update(@Valid @RequestBody Continente nContinente) {
		return repo.save(nContinente);
	}

	@DeleteMapping("/{nombre}")
	public Optional<Continente> Delete(@PathVariable(value = "nombre") String nombre) {
		Optional<Continente> nContinente = repo.findById(nombre);

		if (nContinente != null) {
			repo.deleteById(nombre);
		}

		return nContinente;
	}
}
