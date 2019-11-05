package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mysql.jdbc.Blob;

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

	private int rating;

	private int wins;

	

	private int defeats;

	
	private int draws;
	
	private int totalgoal;

	//private Blob logo;
	

}
