package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SchedinaDTO;
import it.contrader.service.SchedinaService;

@RestController
@RequestMapping("/schedina")
@CrossOrigin(origins = "http://localhost:4200")

public class SchedinaController extends AbstractController<SchedinaDTO>{
	
@Autowired
private SchedinaService schedinaService;

}
