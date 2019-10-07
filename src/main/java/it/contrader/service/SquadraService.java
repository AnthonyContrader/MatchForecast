package it.contrader.service;

import java.util.List;


import it.contrader.converter.SquadraConverter;
import it.contrader.dao.SquadraDAO;
import it.contrader.dto.SquadraDTO;

public class SquadraService {
	private SquadraDAO squadraDAO;
	private SquadraConverter squadraConverter;
	
	public SquadraService(){
		this.squadraDAO = new SquadraDAO();
		this.squadraConverter = new SquadraConverter();
	}
	public List<SquadraDTO> getAll() {
		
		return squadraConverter.toDTOList(squadraDAO.getAll());
	}
	public SquadraDTO read(int id) {
	
		return squadraConverter.toDTO(squadraDAO.read(id));
	}
	public boolean insert(SquadraDTO dto) {
		
		return squadraDAO.insert(squadraConverter.toEntity(dto));
	}
	public boolean update(SquadraDTO dto) {
		System.out.println("ciao");
		return squadraDAO.update(squadraConverter.toEntity(dto));
		
	}
	public boolean delete(int id) {
		
		return squadraDAO.delete(id);
	}
}
