package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PartitaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Partita;
import it.contrader.model.User;

@Component


public class PartitaConverter extends AbstractConverter<Partita,PartitaDTO>  {

	public Partita toEntity(PartitaDTO partitaDTO) {
		Partita partita = null;
		if (partitaDTO != null) {
			partita = new Partita (partitaDTO.getId(),partitaDTO.getTeam1(),partitaDTO.getSquadra(),partitaDTO.getDate(),partitaDTO.getWin(),partitaDTO.getDraw(),partitaDTO.getLose());			
		}
		return partita;
	}

	public PartitaDTO toDTO(Partita partita) {
		PartitaDTO partitaDTO = null;
		if (partita != null) {
		    partitaDTO = new PartitaDTO(partita.getId(),partita.getTeam1(),partita.getSquadra(),partita.getDate(),partita.getWin(),partita.getDraw(),partita.getLose());
			
		}
		return partitaDTO;
	}
	
	
	
}
