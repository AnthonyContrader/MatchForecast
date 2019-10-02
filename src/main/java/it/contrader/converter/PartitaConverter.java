

package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.PartitaDTO;
import it.contrader.model.Partita;





	
	public class PartitaConverter   {
		
		
		public PartitaDTO toDTO(Partita partita) {
			PartitaDTO partitaDTO = new PartitaDTO(partita.getId(), partita.getSquadra1(), partita.getSquadra2(), partita.getData() , partita.getOrario() ,partita.getRisultato());
			return partitaDTO;
		}

		
		public Partita toEntity(PartitaDTO partitaDTO) {
			Partita partita = new Partita(partitaDTO.getId, partitaDTO.getSquadra1(), partitaDTO.getSquadra2(), partitaDTO.getData() , partitaDTO.getOrario() ,partitaDTO.getRisultato());
			return partita;
		}
		
		
		public List<PartitaDTO> toDTOList(List<Partita> partitaList) {
			
			List<PartitaDTO> partitaDTOList = new ArrayList<PartitaDTO>();
			
			
			for(Partita partita : partitaList) {
				
				partitaDTOList.add(toDTO(partita));
			}
			return partitaDTOList;
		} 
	