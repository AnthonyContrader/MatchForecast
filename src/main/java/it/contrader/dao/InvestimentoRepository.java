package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Investimento;

@Repository
@Transactional
	public interface InvestimentoRepository extends CrudRepository<Investimento, Long> {

		Investimento findInvestimentoById(long id);

	}

	


