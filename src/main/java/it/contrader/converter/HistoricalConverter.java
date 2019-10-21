package it.contrader.converter;
import org.springframework.stereotype.Component;

import it.contrader.dto.HistoricalDTO;
import it.contrader.dto.HistoricalDTO;
import it.contrader.model.Historical;
import it.contrader.model.Historical;
import it.contrader.model.Match;
@Component
public class HistoricalConverter extends AbstractConverter<Historical,HistoricalDTO> {
	
	@Override
	public Historical toEntity(HistoricalDTO historicalDTO) {
		Historical historical = null;
		if (historicalDTO != null) {
			historical = new Historical(historicalDTO.getIdHistorical(),historicalDTO.getMatch(),historicalDTO.getResult());			
		}
		return historical;
	}
	@Override
	public HistoricalDTO toDTO(Historical historical) {
		HistoricalDTO historicalDTO = null;
		if (historical != null) {
			historicalDTO = new HistoricalDTO(historical.getIdHistorical(),historical.getMatch(),historical.getResult());
			
		}
		return historicalDTO;
	}
}
