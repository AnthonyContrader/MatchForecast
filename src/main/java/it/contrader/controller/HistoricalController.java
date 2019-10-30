package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.HistoricalDTO;
import it.contrader.service.HistoricalService;

@RestController
@RequestMapping("/historical")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoricalController extends AbstractController<HistoricalDTO>{
	@Autowired
	private HistoricalService historicalService;
}
