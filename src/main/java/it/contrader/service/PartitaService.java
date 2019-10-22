package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.PartitaConverter;
import it.contrader.dao.PartitaRepository;
import it.contrader.dto.PartitaDTO;
import it.contrader.model.Partita;

@Service
public class PartitaService extends AbstractService <Partita,PartitaDTO>{

	@Autowired
	private PartitaConverter converter;
	@Autowired
	private PartitaRepository repository;
	
	public PartitaDTO findPartitaById(long id) {
		return converter.toDTO(repository.findPartitaById(id));
	
	
	}
}