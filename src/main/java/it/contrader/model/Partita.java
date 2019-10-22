package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private long id;
	


	//private Long idcoin;
	
	//relazione Match - Team
	@ManyToOne
	@JoinColumn(name = "idTeam1", referencedColumnName = "id")
	private Team team1;
	
	@ManyToOne
	@JoinColumn(name = "idTeam2", referencedColumnName = "id")
	private Team team2;
	
	
	@Column
	private String date;
	private int win;
	private int draw;
	private int lose;
	

	
	
}