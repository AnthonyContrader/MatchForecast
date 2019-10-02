package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SquadraDTO;
import it.contrader.model.Squadra;
public class SquadraConverter {

	
public SquadraDTO toDTO(Squadra squadra) {
SquadraDTO squadraDTO = new SquadraDTO(squadra.getId(), squadra.getNomeSquadra(), squadra.getNumGiocatori(), squadra.getRating(), squadra.getVittorieCasa(), squadra.getVittorieEsterne(), squadra.getSconfitteCasa(), squadra.getSconfitteEsterne(), squadra.getPareggiCasa(), squadra.getParegiEsterne());
return squadraDTO;
}
public Squadra toEntity(SquadraDTO squadraDTO) {
	Squadra squadra = new Squadra(squadraDTO.getId(), squadraDTO.getNomeSquadra(), squadraDTO.getNumGiocatori(), squadraDTO.getRating(), squadraDTO.getVittorieCasa(), squadraDTO.getVittorieEsterne(), squadraDTO.getSconfitteCasa(), squadraDTO.getSconfitteEsterne(), squadraDTO.getPareggiCasa(), squadraDTO.getParegiEsterne());
	return squadra;	
}
public List<SquadraDTO> toDTOList(List<Squadra> squadraList) {
	
	List<SquadraDTO> squadraDTOList = new ArrayList<SquadraDTO>();

	for(Squadra squadra : squadraList) {
		
		squadraDTOList.add(toDTO(squadra));
	}
	return squadraDTOList;
}
}