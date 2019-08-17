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

import com.cenfotec.examen3.domain.DivisionPolitica;
import com.cenfotec.examen3.repository.DivisionPoliticaRepository;

@RestController
@RequestMapping("division_politica")
public class DivisionPoliticaController {

	@Autowired
	private DivisionPoliticaRepository repo;

	@PostMapping
	public DivisionPolitica Create(@Valid @RequestBody DivisionPolitica nDivPolitica) {
		return repo.save(nDivPolitica);
	}

	@GetMapping
	public List<DivisionPolitica> GetAll(@RequestParam(value = "nombre", required = false) String nombre) {
		if(nombre != null) {
			return repo.findAllByNombreContaining(nombre);
		}
		
		return repo.findAll();
	}

	@GetMapping("/{nombre}")
	public Optional<DivisionPolitica> Get(@PathVariable(value = "nombre") String nombre) {
		return repo.findById(nombre);
	}

	@PutMapping
	public DivisionPolitica Update(@Valid @RequestBody DivisionPolitica nDivPolitica) {
		return repo.save(nDivPolitica);
	}

	@DeleteMapping("/{nombre}")
	public Optional<DivisionPolitica> Delete(@PathVariable(value = "nombre") String nombre) {
		Optional<DivisionPolitica> divPolitica = repo.findById(nombre);

		if (divPolitica != null) {
			repo.deleteById(nombre);
		}

		return divPolitica;
	}
}
