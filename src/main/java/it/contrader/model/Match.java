package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import it.contrader.model.Team;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@ManyToOne
	@JoinColumn(name = "idTeam1", referencedColumnName = "id")
	private Team team1;
/*
	@ManyToOne
	@JoinColumn(name = "idTeam2", referencedColumnName = "id")
	private Team team2;
	*/
	@Column
	private String date;

	private int win;
	private int draw;
	private int lose;

}