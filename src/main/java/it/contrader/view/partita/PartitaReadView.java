package it.contrader.view.partita;

import it.contrader.controller.Request;

import it.contrader.dto.PartitaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PartitaReadView extends AbstractView{
	
	private int id;
	private Request request;
	private final String mode = "READ";

	public PartitaReadView() {
	}
	
	public void showResults(Request request) {
		if (request != null) {
			PartitaDTO partita = (PartitaDTO) request.get("partita");
			System.out.println(partita);
			MainDispatcher.getInstance().callView("Partita", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della partita:");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Partita", "doControl", request);
	}

}
