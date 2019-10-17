package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import it.contrader.model.Squadra;
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
private long nomeSquadra;


@Column
private  int numGiocatori;

private  float rating;

private int vittorieCasa;

private int vittorieEsterne;

private int sconfitteCasa;

private int sconfitteEsterne;

private int pareggiCasa;

private int pareggiEsterne;

}
