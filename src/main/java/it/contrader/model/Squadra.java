package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Squadra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSquadra;

	
	
	@Column(name = "nomeSquadra")
	private String nomeSquadra;
	@Column(name = "numGiocatori")
	private int numGiocatori;
	@Column(name = "rating")
	private float rating;
	@Column(name = "vittorieCasa")
	private int vittorieCasa;
	@Column(name = "vittorieEsterne")
	private int vittorieEsterne;
	@Column(name = "sconfitteCasa")
	private int sconfitteCasa;
	@Column(name = "sconfitteEsterne")
	private int sconfitteEsterne;
	@Column(name = "pareggiCasa")
	private int pareggiCasa;
	@Column(name = "pareggiEsterne")
	private int pareggiEsterne;

}
