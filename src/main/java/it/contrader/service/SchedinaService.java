package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.model.Schedina;
import it.contrader.dto.SchedinaDTO;
import it.contrader.converter.SchedinaConverter;
import it.contrader.dao.SchedinaRepository;

@Service
public class SchedinaService extends AbstractService<Schedina,SchedinaDTO>{
	
	@Autowired
	private SchedinaConverter converter;
	@Autowired
	private SchedinaRepository repository;
	
	public SchedinaDTO findSchedinaById(long id) {
		return converter.toDTO(repository.findSchedinaById(id));
	}

}
