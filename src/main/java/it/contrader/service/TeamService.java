package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.TeamRepository;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;


@Service
public class TeamService extends AbstractService<Team,TeamDTO> {

	public TeamDTO findById(long id) {
		return converter.toDTO(((TeamRepository)repository).findById(id));
	}

}

