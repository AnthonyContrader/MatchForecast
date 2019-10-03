package it.contrader.service;

import java.util.List;


import it.contrader.converter.UserConverter;
import it.contrader.dao.PartitaDAO;
import it.contrader.dto.PartitaDTO;


public class PartitaService {
	
	private PartitaDAO partitaDAO;
	private PartitaConverter partitaConverter;
	
	
	public PartitaService(){
		this.partitaDAO = new ParitaDAO();
		this.partitaConverter = new PartitaConverter();
	}
	

	public List<PartitaDTO> getAll() {
		
		return partitaConverter.toDTOList(partitaDAO.getAll());
	}


	public PartitaDTO read(int id) {
		
		return partitaConverter.toDTO(partitaDAO.read(id));
	}


	public boolean insert(PartitaDTO dto) {
		
		return partitaDAO.insert(partitaConverter.toEntity(dto));
	}


	public boolean update(PartitaDTO dto) {
		
		return partitaDAO.update(partitaConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		
		return partitaDAO.delete(id);
	}
	

}
