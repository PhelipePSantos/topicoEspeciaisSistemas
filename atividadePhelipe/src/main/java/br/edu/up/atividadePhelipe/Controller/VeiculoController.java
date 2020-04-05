package br.edu.up.atividadePhelipe.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.atividadePhelipe.entity.Veiculo;
import br.edu.up.atividadePhelipe.repository.VeiculoRepository;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {
	@Autowired
	private VeiculoRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Veiculo> listAll(){
		Iterable<Veiculo> list = repository.findAll();
		return list;
	}
	@GetMapping("/{id}")
	public @ResponseBody Veiculo getById(@PathVariable Integer Id) {
		Veiculo veiculo = repository.getOne(Id);
		return veiculo;
	}
	
	@PostMapping
	public Veiculo add(@RequestBody @Valid Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
	public Veiculo delete(@PathVariable Integer id) {
		Veiculo veiculo = repository.getOne(id);
		repository.delete(veiculo);
		return veiculo;
	}
}