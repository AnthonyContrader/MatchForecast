package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PartitaDTO;

import it.contrader.service.PartitaService;

@RestController
@RequestMapping("/partita")
@CrossOrigin(origins = "http://localhost:4200")

public class PartitaController extends AbstractController<PartitaDTO> {

	@Autowired
	private PartitaService partitaService;

	//POST Angular a UserDTO

	@PostMapping(value = "/partitas")
	public PartitaDTO insert( @RequestBody PartitaDTO partitaDTO ) {
		return partitaService.insert(partitaDTO);
	}
	

}
