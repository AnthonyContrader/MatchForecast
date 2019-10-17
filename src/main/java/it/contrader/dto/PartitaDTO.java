package it.contrader.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PartitaDTO {
	
	private long idPartita;
	
	private long codiceForecast;
	
	private String squadra1;

	private String squadra2;

	private int data;

	private int orario;

	private int goalCasa;

	private int goalTrasferta;

	
	
	
	
	
	
	
	
}

