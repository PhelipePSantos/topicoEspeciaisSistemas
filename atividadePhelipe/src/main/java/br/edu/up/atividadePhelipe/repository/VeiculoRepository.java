package br.edu.up.atividadePhelipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.up.atividadePhelipe.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
	@Query(value ="SELECT * FROM Veiculo WHERE cor =?", nativeQuery = true)	
	List<Veiculo> getAllByCor(String cor);
}
