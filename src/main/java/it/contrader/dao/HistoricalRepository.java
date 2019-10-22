package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Historical;

@Repository
@Transactional
public interface HistoricalRepository extends CrudRepository<Historical, Long>{
		Historical findHistoricalById(long id);
		
	}

