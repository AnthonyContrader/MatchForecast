package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.HistoricalRepository;
import it.contrader.dto.HistoricalDTO;
import it.contrader.model.Historical;
public class HistoricalService extends AbstractService<Historical,HistoricalDTO> {
	
	
	public HistoricalDTO findByIdHistorical(long idHistorical) {
		return converter.toDTO(((HistoricalRepository)repository).findByIdHistorical(idHistorical));
	}

}