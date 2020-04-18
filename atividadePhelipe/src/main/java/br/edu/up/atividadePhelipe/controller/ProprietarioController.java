package br.edu.up.atividadePhelipe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.atividadePhelipe.entity.Proprietario;
import br.edu.up.atividadePhelipe.repository.ProprietarioRepository;

@RestController
@RequestMapping("proprietario")
public class ProprietarioController {
	@Autowired
	private ProprietarioRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Proprietario> listAll(){
		Iterable<Proprietario> list = repository.findAll();
		return list;
	}
	@GetMapping("/id={id}")
	public @ResponseBody Proprietario getById(@PathVariable Integer Id) {
		Proprietario proprietario = repository.getOne(Id);
		return proprietario;
	}
	
	@PostMapping
	public Proprietario add(@RequestBody @Valid Proprietario proprietario) {
		return repository.save(proprietario);
	}
	
	public Proprietario delete(@PathVariable Integer id) {
		Proprietario proprietario = repository.getOne(id);
		repository.delete(proprietario);
		return proprietario;
	}

	@GetMapping("/nome={nome}")
	public Proprietario GetProprietarioByNome(@PathVariable String nome) {
		Proprietario proprietario= repository.getProprietarioByNome(nome);
		return proprietario;
	}
}