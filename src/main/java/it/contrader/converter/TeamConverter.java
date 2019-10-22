package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TeamDTO;

import it.contrader.model.Team;

@Component
public class TeamConverter extends AbstractConverter<Team,TeamDTO> {

	@Override
	public Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO != null) {
			team = new Team(teamDTO.getId(),teamDTO.getNameTeam(),teamDTO.getNumPlayers(),teamDTO.getRating(),teamDTO.getHomeWins(),teamDTO.getTransferWins(),teamDTO.getHomeDefeats(),teamDTO.getTransferDefeats(),teamDTO.getHomeDraws(),teamDTO.getTransferDraws());			
		}
		return team;
	}

	@Override
	public TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO(team.getId(),team.getNameTeam(),team.getNumPlayers(),team.getRating(),team.getHomeWins(),team.getTransferWins(),team.getHomeDefeats(),team.getTransferDefeats(),team.getHomeDraws(),team.getTransferDraws());
			
		}
		return teamDTO;
	}
}
