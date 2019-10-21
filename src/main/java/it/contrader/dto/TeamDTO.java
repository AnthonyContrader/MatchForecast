package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TeamDTO {

	private long id;
	
	private String nameTeam;

	private int numPlayers;

	private float rating;

	private int homeWins;

	private int transferWins;

	private int homeDefeats;

	private int transferDefeats;

	private int homeDraws;

	private int transferDraws;
	

}
