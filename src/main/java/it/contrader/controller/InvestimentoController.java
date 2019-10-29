package it.contrader.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.InvestimentoDTO;
import it.contrader.service.InvestimentoService;

@RestController
@RequestMapping("/investimento")
@CrossOrigin(origins = "http://localhost:4200")

public class InvestimentoController extends AbstractController<InvestimentoDTO> {

	@Autowired
	private InvestimentoService investimentoService;

	

}