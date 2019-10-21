package it.contrader.service;
import org.springframework.stereotype.Service;

import it.contrader.dao.MatchRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.MatchDTO;

import it.contrader.model.Match;
@Service
public class MatchService extends AbastractService <Match,MatchDTO>{

	public MatchDTO findByIdMatch(long idMatch) {
		return converter.toDTO(((MatchRepository)repository).findByIdMatch(idMatch));
	
	
}
