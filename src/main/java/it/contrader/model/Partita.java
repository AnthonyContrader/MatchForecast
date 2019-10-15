package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import it.contrader.model.Partita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Partita {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idPartita;

@ManyToOne
@JoinColumn(name = "codiceForecast")
private Long codiceForecast;

@Column

private String squadra1;

private String squadra2;

private int data;

private int orario;

private int goalCasa;

private int goalTrasferta;


}
