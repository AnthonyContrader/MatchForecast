package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PartitaConverter;
import it.contrader.dao.PartitaRepository;
import it.contrader.dto.PartitaDTO;
import it.contrader.model.Partita;

@Service
public class PartitaService extends AbstractService<Partita, PartitaDTO> {

	@Autowired //ogni autowired corrisponde ad una ingection 
	private PartitaConverter converter;
	@Autowired
	private PartitaRepository repository;

	public PartitaDTO findByIdPartita(long idPartita) {//spring data
		return converter.toDTO(repository.findByIdPartita(idPartita));
	}

}
