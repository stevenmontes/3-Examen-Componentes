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

import com.cenfotec.examen3.domain.Animal;
import com.cenfotec.examen3.domain.DivisionBiologica;
import com.cenfotec.examen3.domain.DivisionPolitica;
import com.cenfotec.examen3.domain.Pais;
import com.cenfotec.examen3.repository.PaisRepository;

@RestController
@RequestMapping("pais")
public class PaisController {

	@Autowired
	private PaisRepository repo;

	@PostMapping
	public Pais Create(@Valid @RequestBody Pais nPais) {
		return repo.save(nPais);
	}

	@GetMapping
	public List<Pais> GetAll() {
		return repo.findAll();
	}

	@GetMapping("/{sigla}")
	public Optional<Pais> Get(@PathVariable(value = "sigla") String nSigla) {
		return repo.findById(nSigla);
	}

	@GetMapping("/{sigla}/divisiones_politicas")
	public List<DivisionPolitica> GetDivisionesPoliticasByPais(@PathVariable(value = "sigla") String nSigla) {
		return repo.getProvincias(nSigla);
	}

	@GetMapping("/{sigla}/divisiones_biologicas")
	public List<DivisionBiologica> GetDivisionesBiologicasByPais(@PathVariable(value = "sigla") String nSigla) {
		return repo.getAreasBiologicas(nSigla);
	}
	
	@GetMapping("/{sigla}/animales")
	public List<Animal> GetAnimalesByPais(@PathVariable("sigla") String nSigla){
		return repo.getAnimales(nSigla);
	}

	@PutMapping
	public Pais Update(@Valid @RequestBody Pais nPais) {
		return repo.save(nPais);
	}

	@DeleteMapping("/{sigla}")
	public Optional<Pais> Delete(@PathVariable(value = "sigla") String nSigla) {
		Optional<Pais> nPais = repo.findById(nSigla);

		if (nPais != null) {
			repo.deleteById(nSigla);
		}

		return nPais;
	}
}
