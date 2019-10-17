package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Squadra;


@Repository
@Transactional
public interface SquadraRepository extends CrudRepository<Squadra, Long> {

	Squadra findByNomeSquadra(Long nomeSquadra);

}