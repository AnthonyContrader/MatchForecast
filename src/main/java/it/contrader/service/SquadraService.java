package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.SquadraConverter;
import it.contrader.dao.SquadraRepository;
import it.contrader.dto.SquadraDTO;
import it.contrader.model.Squadra;;

@Service
public class SquadraService extends AbstractService<Squadra, SquadraDTO> {

	@Autowired
	private SquadraConverter converter;
	@Autowired
	private SquadraRepository repository;

	public SquadraDTO findByIdSquadra(long idSquadra) {
		return converter.toDTO(repository.findByIdSquadra(idSquadra));
	}

}

