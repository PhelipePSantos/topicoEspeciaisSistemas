package br.edu.up.atividadePhelipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.up.atividadePhelipe.entity.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer>{

	@Query(value ="SELECT * FROM proprietario WHERE nome =?1", nativeQuery = true)	
	Proprietario getProprietarioByNome(String nome);
	
	@Query(value ="SELECT * FROM Proprietario WHERE telefone =?", nativeQuery = true)
	List<Proprietario> getAllByCategoria(String categoria);
	
}
