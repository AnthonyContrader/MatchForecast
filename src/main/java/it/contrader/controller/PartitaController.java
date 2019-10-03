package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PartitaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.PartitaService;


public class PartitaController implements Controller {

	
	private static String sub_package = "partita.";
	
	private PartitaService partitaService;
	
	public PartitaController() {
		this.partitaService = new PartitaService();
	}
	
	
	
	
	@Override
	public void doControl(Request request) {
		
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		
		int id;
		String squadra1;
		String squadra2;
		int data;
		int orario;
		
		String risultato;

		switch (mode) {
		
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			UserDTO userDTO = userService.read(id);
			request.put("partita", partitaDTO);
			MainDispatcher.getInstance().callView(sub_package + "PartitaRead", request);
			break;
		
		
		case "INSERT":
			squadra1 = request.get("squadra1").toString();
			squadra2 = request.get("squadra2").toString();
			data = request.get("data").toString();
			orario = request.get("orario").toString();
			risultato = request.get("risultato").toString();
			
			
			PartitaDTO partitatoinsert = new PartitaDTO(squadra1, squadra2, data, orario, risultato);
			
			partitaService.insert(partitatoinsert);
			request = new Request();
			request.put("mode", "mode");
			
			MainDispatcher.getInstance().callView(sub_package + "PartitaInsert", request);
			break;
		
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			partitaService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PartitaDelete", request);
			break;
		
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			squadra1 = request.get("squadra1").toString();
			squadra2 = request.get("squadra2").toString();
			data = request.get("data").toString();
			orario = request.get("orario").toString();
			risultato = request.get("risultato").toString();
			PartitaDTO partitatoupdate = new PartitaDTO(squadra1, squadra2, data, orario, risultato);
			usertoupdate.setId(id);
			partitaService.update(partitatoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PartitaUpdate", request);
			break;
			
		 
		case "USERLIST":
			List<PartiteDTO> partiteDTO = partitaService.getAll();
			
			request.put("partite", partiteDTO);
			MainDispatcher.getInstance().callView("Partita", request);
			break;
			
		
		case "GETCHOICE":
					
					
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PartitaRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PartitaInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "PartitaUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PartitaDelete", null);
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

