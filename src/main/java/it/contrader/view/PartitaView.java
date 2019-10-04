package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.PartitaDTO;
import it.contrader.main.MainDispatcher;

public class PartitaView extends AbstractView {

	private Request request;
	private String choice;

	public PartitaView() {
		
	}


@Override
public void showResults(Request request) {
	if (request != null) {
		System.out.println("\n------------------- Gestione partite ----------------\n");
		System.out.println("ID\tSquadra1\tSquadra2\tOrario\tData\tRisultato\tTipo Partite");
		System.out.println("----------------------------------------------------\n");
		
		@SuppressWarnings("unchecked")
		List<PartitaDTO> partite = (List<PartitaDTO>) request.get("partite");
		for (PartitaDTO u: partite)
			System.out.println(u);
		System.out.println();
	}
}


@Override
public void showOptions() {

		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}


@Override
public void submit() {
	
	request = new Request();
	request.put("choice", choice);
	request.put("mode", "GETCHOICE");
	MainDispatcher.getInstance().callAction("Partita", "doControl", this.request);
}

}


