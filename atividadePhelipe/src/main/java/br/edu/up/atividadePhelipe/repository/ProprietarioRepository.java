package br.edu.up.atividadePhelipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.up.atividadePhelipe.entity.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer>{

	
}
