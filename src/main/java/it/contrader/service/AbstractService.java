package it.contrader.service;

import java.util.List;

import it.contrader.converter.Converter;
import it.contrader.dao.DAO;


 
public abstract class AbstractService<Entity,DTO> implements Service<DTO> {

	protected DAO<Entity> dao;
	
	protected Converter<Entity,DTO> converter;
	
	@Override
	public List<DTO> getAll() {
		// Ottiene una lista di entit� e le restituisce convertendole in DTO
		return converter.toDTOList(dao.getAll());
	}

	@Override
	public DTO read(int id) {
		// Ottiene un'entit� e la restituisce convertendola in DTO
		return converter.toDTO(dao.read(id));
	}

	@Override
	public boolean insert(DTO dto) {
		// Converte un DTO in entit� e lo passa al DAO per l'inserimento
		return dao.insert(converter.toEntity(dto));
	}

	@Override
	public boolean update(DTO dto) {
		// Converte un DTO in entit� e lo passa al DAO per la modifica
		return dao.update(converter.toEntity(dto));
	}

	@Override
	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return dao.delete(id);
	}

}
