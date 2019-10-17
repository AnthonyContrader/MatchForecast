package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SquadraDTO;
import it.contrader.model.Squadra;

@Component
public class SquadraConverter extends AbstractConverter<Squadra, SquadraDTO> {

	@Override
	public Squadra toEntity(SquadraDTO squadraDTO) {
		Squadra squadra = null;
		if (squadraDTO != null) {
			squadra = new Squadra(squadraDTO.getNomeSquadra(), squadraDTO.getNumGiocatori(), squadraDTO.getRating(), squadraDTO.getVittorieCasa(),squadraDTO.getVittorieEsterne(),squadraDTO.getSconfitteCasa(),squadraDTO.getSconfitteEsterne(),squadraDTO.getPareggiCasa(),squadraDTO.getPareggiEsterne());
		}
		return squadra;
	}

	@Override
	public SquadraDTO toDTO(Squadra squadra) {
		SquadraDTO squadraDTO = null;
		if (squadra != null) {
			squadraDTO = new SquadraDTO(squadra.getNomeSquadra(), squadra.getNumGiocatori(), squadra.getRating(), squadra.getVittorieCasa(),squadra.getVittorieEsterne(),squadra.getSconfitteCasa(),squadra.getSconfitteEsterne(),squadra.getPareggiCasa(),squadra.getPareggiEsterne());

		}
		return squadraDTO;
	}

}