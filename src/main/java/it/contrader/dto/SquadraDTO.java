package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadraDTO {
	

    private long idSquadra;
    
	private String nomeSquadra;
	
	private int numGiocatori;
	
	private float rating;
	
	private int vittorieCasa;
	
	private int vittorieEsterne;
	
	private int sconfitteCasa;
	
	private int sconfitteEsterne;
	
	private int pareggiCasa;
	
	private int pareggiEsterne;
}

