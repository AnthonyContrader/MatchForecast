package it.contrader.dto;
import it.contrader.model.Partita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PartitaDTO {
	
	private Long idPartita;
	
	private Long codiceForecast;
	
	private String squadra1;

	private String squadra2;

	private int data;

	private int orario;

	private int goalCasa;

	private int goalTrasferta;

	
	
	
	
	
	
	
	
}

