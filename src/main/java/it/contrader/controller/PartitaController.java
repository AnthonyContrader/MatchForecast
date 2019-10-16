package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PartitaDTO;

import it.contrader.model.Partita;
import it.contrader.service.PartitaService;


@Controller
@RequestMapping("/partita")
public class PartitaController {

	@Autowired
	private PartitaService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "partita";
	}
	

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("IdPartita") Long idPartita) {
		service.delete(idPartita);
		setAll(request);
		return "partita";
	}
	
   @GetMapping("/preupdate")
   public String preUpdate(HttpServletRequest request,@RequestParam("IdPartita") Long idPartita) {
	     request.getSession().setAttribute("dto", service.read(idPartita));
	     return "updatepartita";
   }

@PostMapping("/update")

public String update(HttpServletRequest request, @RequestParam("idPartita") Long idPartita, @RequestParam("codiceForecast") Long codiceForecast,
		@RequestParam("squadra1") String squadra1, @RequestParam("squadra2") String squadra2,@RequestParam("data") int data,
		@RequestParam("orario") int orario,@RequestParam("goalCasa") int goalCasa,@RequestParam("goalTrasferta") int goalTrasferta) {

	PartitaDTO dto = new PartitaDTO();
	dto.setIdPartita(idPartita);
	dto.setCodiceForecast(codiceForecast);
	dto.setSquadra1(squadra1);
	dto.setSquadra2(squadra2);
	dto.setData(data);
	dto.setOrario(orario);
	dto.setGoalCasa(goalCasa);
	dto.setGoalTrasferta(goalTrasferta);
	service.update(dto);
	setAll(request);
	return "partite";

}


@PostMapping("/insert")

public String insert(HttpServletRequest request, @RequestParam("idPartita") Long idPartita, @RequestParam("codiceForecast") Long codiceForecast,
		@RequestParam("squadra1") String squadra1, @RequestParam("squadra2") String squadra2,@RequestParam("data") int data,
		@RequestParam("orario") int orario,@RequestParam("goalCasa") int goalCasa,@RequestParam("goalTrasferta") int goalTrasferta) {

	PartitaDTO dto = new PartitaDTO();
	dto.setIdPartita(idPartita);
	dto.setCodiceForecast(codiceForecast);
	dto.setSquadra1(squadra1);
	dto.setSquadra2(squadra2);
	dto.setData(data);
	dto.setOrario(orario);
	dto.setGoalCasa(goalCasa);
	dto.setGoalTrasferta(goalTrasferta);
	service.update(dto);
	setAll(request);
	return "partite";

}


@GetMapping("/read")
public String read(HttpServletRequest request, @RequestParam("idPartita") Long idPartita) {
	request.getSession().setAttribute("dto", service.read(idPartita));
	return "readpartita";
}

@GetMapping("/logout")
public String logout(HttpServletRequest request) {
	request.getSession().invalidate();
	return "index";
}

private void setAll(HttpServletRequest request) {
	request.getSession().setAttribute("list", service.getAll());
}





}