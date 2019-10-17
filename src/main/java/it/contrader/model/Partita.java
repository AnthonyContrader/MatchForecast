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

public class Partita {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idPartita;




@Column
private long codiceForecast;

private String squadra1;

private String squadra2;

private int data;

private int orario;

private int goalCasa;

private int goalTrasferta;


}
