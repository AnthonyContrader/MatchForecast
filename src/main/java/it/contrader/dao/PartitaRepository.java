package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Partita;

@Repository
@Transactional
public interface PartitaRepository extends CrudRepository<Partita, Long> {

	Partita findPartitaById(long id);

}
