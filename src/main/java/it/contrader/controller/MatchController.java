package it.contrader.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.MatchDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.MatchService;
import it.contrader.service.UserService;
@RestController
@RequestMapping("/match")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchController extends AbstractController<MatchDTO> {

	@Autowired
	private MatchService matchService;

	

}
