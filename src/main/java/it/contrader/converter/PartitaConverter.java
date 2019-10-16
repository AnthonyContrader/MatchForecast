package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PartitaDTO;

import it.contrader.model.Partita;

@Component
public class PartitaConverter extends AbstractConverter<Partita, PartitaDTO> {

	@Override
	public Partita toEntity(PartitaDTO partitaDTO) {
		Partita partita = null;
		if (partitaDTO != null) {
			partita = new Partita(partitaDTO.getIdPartita(), partitaDTO.getCodiceForecast(), partitaDTO.getSquadra1(),partitaDTO.getSquadra2(), partitaDTO.getData(),partitaDTO.getOrario(),partitaDTO.getGoalCasa(),partitaDTO.getGoalTrasferta());
		}
		return partita;
	}

	@Override
	public PartitaDTO toDTO(Partita partita) {
		PartitaDTO partitaDTO = null;
		if (partita != null) {
			partitaDTO = new PartitaDTO(partita.getIdPartita(), partita.getCodiceForecast(), partita.getSquadra1(),partita.getSquadra2(), partita.getData(),partita.getOrario(),partita.getGoalCasa(),partita.getGoalTrasferta());

		}
		return partitaDTO;
	}
}