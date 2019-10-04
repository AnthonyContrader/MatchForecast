package it.contrader.view.squadre;
import it.contrader.controller.Request;

import it.contrader.dto.SquadraDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SquadraReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public SquadraReadView() {
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			SquadraDTO user = (SquadraDTO) request.get("user");
			System.out.println(user);
			MainDispatcher.getInstance().callView("Squadra", null);
		}
	}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della squadra:");
		id = Integer.parseInt(getInput());
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Squadra", "doControl", request);
	}
}

