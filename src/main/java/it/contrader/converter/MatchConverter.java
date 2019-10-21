package it.contrader.converter;
import org.springframework.stereotype.Component;

import it.contrader.dto.MatchDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Match;
import it.contrader.model.User;
@Component
public class MatchConverter extends AbstractConverter<Match ,MatchDTO> {
	

	@Override
	public Match toEntity(MatchDTO matchDTO) {
		Match match = null;
		if (matchDTO != null) {
			match = new Match (matchDTO.getIdMatch(),matchDTO.getTeam1(),matchDTO.getTeam2(),matchDTO.getDate(),matchDTO.getWin(),matchDTO.getDraw(),matchDTO.getLose());			
		}
		return match;
	}

	@Override
	public MatchDTO toDTO(Match match) {
		MatchDTO matchDTO = null;
		if (match != null) {
		    matchDTO = new MatchDTO(match.getIdMatch(),match.getTeam1(),match.getTeam2(),match.getDate(),match.getWin(),match.getDraw(),match.getLose());
			
		}
		return matchDTO;
	}
}
