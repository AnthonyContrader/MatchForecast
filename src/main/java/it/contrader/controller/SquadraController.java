package it.contrader.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SquadraDTO;
import it.contrader.service.SquadraService;

@Controller
@RequestMapping("/squadre")
public class SquadraController {
	
	@Autowired
	private SquadraService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "squadre";
	}
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idSquadra") long idSquadra) {
		service.delete(idSquadra);
		setAll(request);
		return "squadre";
	}
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idSquadra") long idSquadra) {
		request.getSession().setAttribute("dto", service.read(idSquadra));
		return "updatesquadra";
	}
	@PostMapping("/update")
	public String update(HttpServletRequest request,@RequestParam("idSquadra") long idSquadra, @RequestParam("nomeSquadra") String nomeSquadra,
			@RequestParam("numGiocatori") int numGiocatori,@RequestParam("rating") float rating, @RequestParam("vittorieCasa") int vittorieCasa,
			@RequestParam("vittorieEsterne") int vittorieEsterne,@RequestParam("sconfitteCasa") int sconfitteCasa,@RequestParam("sconfitteEsterne") int sconfitteEsterne,@RequestParam("pareggiCasa") int pareggiCasa,@RequestParam("pareggiEsterne") int pareggiEsterne) {

		SquadraDTO dto = new SquadraDTO();
		dto.setIdSquadra(idSquadra);
		dto.setNomeSquadra(nomeSquadra);
		dto.setNumGiocatori(numGiocatori);
		dto.setRating(rating);
		dto.setVittorieCasa(vittorieCasa);
		dto.setVittorieEsterne(vittorieEsterne);
		dto.setSconfitteCasa(sconfitteCasa);
		dto.setSconfitteEsterne(sconfitteEsterne);
		dto.setPareggiCasa(pareggiCasa);
		dto.setPareggiEsterne(pareggiEsterne);
		service.update(dto);
		setAll(request);
		return "squadre";

	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request,@RequestParam("nomeSquadra") String nomeSquadra,
			@RequestParam("numGiocatori") int numGiocatori, @RequestParam("rating") float rating,@RequestParam("vittorieCasa") int vittorieCasa,@RequestParam("vittorieEsterne") int vittorieEsterne,
			@RequestParam("sconfitteCasa") int sconfitteCasa,@RequestParam("sconfitteEsterne") int sconfitteEsterne,@RequestParam("pareggiCasa") int pareggiCasa,@RequestParam("pareggiEsterne") int pareggiEsterne) {
		SquadraDTO dto = new SquadraDTO();
		
		dto.setNomeSquadra(nomeSquadra);
		dto.setNumGiocatori(numGiocatori);
		dto.setRating(rating);
		dto.setVittorieCasa(vittorieCasa);
		dto.setVittorieEsterne(vittorieEsterne);
		dto.setSconfitteCasa(sconfitteCasa);
		dto.setSconfitteEsterne(sconfitteEsterne);
		dto.setPareggiCasa(pareggiCasa);
		dto.setPareggiEsterne(pareggiEsterne);
		service.insert(dto);
		setAll(request);
		return "squadre";
	}
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idSquadra") long idSquadra) {
		request.getSession().setAttribute("dto", service.read(idSquadra));
		return "readsquadra";
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
