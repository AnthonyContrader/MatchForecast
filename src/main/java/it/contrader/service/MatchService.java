package it.contrader.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.MatchConverter;
import it.contrader.dao.MatchRepository;
import it.contrader.dto.MatchDTO;

import it.contrader.model.Match;
@Service
public class MatchService extends AbstractService <Match,MatchDTO>{

	@Autowired
	private MatchConverter converter;
	@Autowired
	private MatchRepository repository;
	
	public MatchDTO findByIdMatch(long id) {
		return converter.toDTO(repository.findMatchById(id));
	
	
	}
}