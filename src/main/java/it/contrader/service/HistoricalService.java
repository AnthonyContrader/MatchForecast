package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.HistoricalConverter;
import it.contrader.converter.PartitaConverter;
import it.contrader.dao.HistoricalRepository;
import it.contrader.dao.PartitaRepository;
import it.contrader.dto.HistoricalDTO;
import it.contrader.model.Historical;

@Service

public class HistoricalService extends AbstractService<Historical,HistoricalDTO> {
	
	@Autowired
	private HistoricalConverter converter;
	@Autowired
	private HistoricalRepository repository;
	
	public HistoricalDTO findHistoricalById(long id) {
		return converter.toDTO(repository.findHistoricalById(id));
	}
}