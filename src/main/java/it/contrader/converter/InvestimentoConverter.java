package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.InvestimentoDTO;
import it.contrader.dto.PartitaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Investimento;
import it.contrader.model.Partita;
import it.contrader.model.User;

@Component
public class InvestimentoConverter extends AbstractConverter<Investimento,InvestimentoDTO>  {

	public Investimento toEntity(InvestimentoDTO investimentoDTO) {
		Investimento investimento = null;
		if (investimentoDTO != null) {
			investimento = new Investimento (investimentoDTO.getId(),investimentoDTO.getUser(),investimentoDTO.getBudget(),investimentoDTO.getDurata(),investimentoDTO.getRischio());			
		}
		return investimento;
	}

	public InvestimentoDTO toDTO(Investimento investimento) {
		InvestimentoDTO investimentoDTO = null;
		if (investimento != null) {
		    investimentoDTO = new InvestimentoDTO(investimento.getId(),investimento.getUser(),investimento.getBudget(),investimento.getDurata(),investimento.getRischio());
			
		}
		return investimentoDTO;
	}

	
}
