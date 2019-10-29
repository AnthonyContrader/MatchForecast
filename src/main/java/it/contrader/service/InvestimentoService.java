package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.InvestimentoConverter;
import it.contrader.dao.InvestimentoRepository;
import it.contrader.dto.InvestimentoDTO;
import it.contrader.model.Investimento;

@Service
public class InvestimentoService extends AbstractService <Investimento,InvestimentoDTO>{

	@Autowired
	private InvestimentoConverter converter;
	@Autowired
	private InvestimentoRepository repository;
	
	public InvestimentoDTO findInvestimentoById(long id) {
		return converter.toDTO(repository.findInvestimentoById(id));
	
	
	}
}
