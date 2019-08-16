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
	public List<Pais> GetAll(){
		return repo.findAll();
	}
	
	@GetMapping("/{sigla}")
	public Optional<Pais> Get(@PathVariable(name = "sigla") String nSigla){
		return repo.findById(nSigla);
	}
	
	@PutMapping
	public Pais Update(@Valid @RequestBody Pais nPais) {
		return repo.save(nPais);
	}
	
	@DeleteMapping("/{sigla}")
	public Optional<Pais> Delete(@PathVariable(name = "sigla") String nSigla){
		Optional<Pais> nPais = repo.findById(nSigla);
		
		if(nPais != null) {
			repo.deleteById(nSigla);
		}
		
		return nPais;
	}
}