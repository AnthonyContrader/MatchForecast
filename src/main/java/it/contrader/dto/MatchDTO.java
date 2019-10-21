package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.Match;
import it.contrader.model.Team;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMatch")
public class MatchDTO {
	private long idMatch;
	private Team team1;
	private Team team2;

	private String date;

	private int win;
	private int draw;
	private int lose;

}
