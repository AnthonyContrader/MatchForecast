
package it.contrader.controller;

import java.util.List;

import it.contrader.dto.SquadraDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SquadraService;

public class SquadraController implements Controller {
	
private static String sub_package = "squadra.";
	
	private SquadraService squadraService;
	

	public SquadraController() {
		
		this.squadraService = new SquadraService();
	}
	
	@Override
	public void doControl(Request request) {
		
	
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		
		int id;
		String nomeSquadra;
		int numGiocatori;
		int rating;
		int vittorieCasa;
		int vittorieEsterne;
		int sconfitteCasa;
		int sconfitteEsterne;
		int pareggiCasa;
		int pareggiEsterne;

		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			SquadraDTO squadraDTO = squadraService.read(id);
			request.put("squadra", squadraDTO);
			MainDispatcher.getInstance().callView(sub_package + "SquadraRead", request);
			break;
		
		
		case "INSERT" :
			nomeSquadra = request.get("nomeSquadra").toString();
			numGiocatori = Integer.parseInt(request.get("numGiocatori").toString());
			rating = Integer.parseInt(request.get("rating").toString());
			vittorieCasa = Integer.parseInt(request.get("vittorieCasa").toString());
			vittorieEsterne = Integer.parseInt(request.get("vittorieEsterne").toString());
			sconfitteCasa = Integer.parseInt(request.get("sconfitteCasa").toString());
			sconfitteEsterne = Integer.parseInt(request.get("sconfitteEsterne").toString());
			pareggiCasa = Integer.parseInt(request.get("pareggiCasa").toString());
			pareggiEsterne = Integer.parseInt(request.get("pareggiEsterne").toString());
			
			SquadraDTO squadratoinsert = new SquadraDTO(nomeSquadra, numGiocatori, rating, vittorieCasa, vittorieEsterne, sconfitteCasa, sconfitteEsterne, pareggiCasa, pareggiEsterne);
			squadraService.insert(squadratoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SquadraInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			squadraService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SquadraDelete", request);
			break;
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			nomeSquadra = request.get("nomeSquadra").toString();
			numGiocatori = Integer.parseInt(request.get("numGiocatori").toString());
			rating = Integer.parseInt(request.get("rating").toString());
			vittorieCasa = Integer.parseInt(request.get("vittorieCasa").toString());
			vittorieEsterne = Integer.parseInt(request.get("vittorieEsterne").toString());
			sconfitteCasa = Integer.parseInt(request.get("sconfitteCasa").toString());
			sconfitteEsterne = Integer.parseInt(request.get("sconfitteEsterne").toString());
			pareggiCasa = Integer.parseInt(request.get("pareggiCasa").toString());
			pareggiEsterne = Integer.parseInt(request.get("pareggiEsterne").toString());
			
			SquadraDTO squadratoupdate = new SquadraDTO(nomeSquadra, numGiocatori, rating, vittorieCasa, vittorieEsterne, sconfitteCasa, sconfitteEsterne, pareggiCasa, pareggiEsterne);
			squadratoupdate.setId(id);
			squadraService.update(squadratoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SquadraUpdate", request);
			break;
			
		case "SQUADRALIST":
			List<SquadraDTO> squadreDTO = squadraService.getAll();
			request.put("squadra", squadreDTO);
			MainDispatcher.getInstance().callView("Squadra", request);
			break;
			
		
		case "GETCHOICE":
					
					
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "SquadraRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "SquadraInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "SquadraUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "SquadraDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
	

}
