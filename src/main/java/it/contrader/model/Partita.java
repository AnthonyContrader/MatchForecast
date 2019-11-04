package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "idTeam1", referencedColumnName = "id")
	private Team team1;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "idTeam2", referencedColumnName = "id")
	private Team squadra;
	
	
	@Column
	private String date;
	private int win;
	private int draw;
	private int lose;
	

	
	
}
