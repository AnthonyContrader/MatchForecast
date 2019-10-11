package it.contrader.service;

import it.contrader.converter.PartitaConverter;
import it.contrader.dao.PartitaDAO;
import it.contrader.dto.PartitaDTO;
import it.contrader.model.Partita;


public class PartitaService extends AbstractService<Partita, PartitaDTO> {
	
	
	public PartitaService(){
		this.dao = new PartitaDAO();
		this.converter = new PartitaConverter();
	}
	

}