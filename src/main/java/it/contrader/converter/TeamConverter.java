package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TeamDTO;

import it.contrader.model.Team;

@Component
public class TeamConverter extends AbstractConverter<Team,TeamDTO> {

	
	public Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO != null) {
			team = new Team(teamDTO.getId(),teamDTO.getNameTeam(),teamDTO.getNumPlayers(),teamDTO.getRating(),teamDTO.getWins(),teamDTO.getDefeats(),teamDTO.getDraws(),teamDTO.getTotalgol()/*,teamDTO.getLogo()*/);			
		}
		return team;
	}

	
	public TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO(team.getId(),team.getNameTeam(),team.getNumPlayers(),team.getRating(),team.getWins(),team.getDefeats(),team.getDraws(),team.getTotalgoal()/*,team.getLogo()*/);
			
		}
		return teamDTO;
	}
}
