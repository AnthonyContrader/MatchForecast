package it.contrader.converter;
import org.springframework.stereotype.Component;
import it.contrader.model.Schedina;
import it.contrader.dto.SchedinaDTO;


@Component

public class SchedinaConverter extends AbstractConverter<Schedina,SchedinaDTO>{
	
	public Schedina toEntity(SchedinaDTO schedinaDTO) {
		Schedina schedina = null;
		if (schedinaDTO != null) {
			schedina = new Schedina (schedinaDTO.getId(),schedinaDTO.getPartita(),schedinaDTO.getQuota1(),schedinaDTO.getQuotaX(),schedinaDTO.getQuota2());			
		}
		return schedina;
	}
	
	public SchedinaDTO toDTO(Schedina schedina) {
		SchedinaDTO schedinaDTO = null;
		if (schedina != null) {
		    schedinaDTO = new SchedinaDTO(schedina.getId(),schedina.getPartita(),schedina.getQuota1(),schedina.getQuotaX(),schedina.getQuota2());
			
		}
		return schedinaDTO;
	}
	}


