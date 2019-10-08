package it.contrader.view.partita;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PartitaUpdateView extends AbstractView {

	private Request request;

	private int id;
	private String squadra1;
	private String squadra2;
	private int orario;
	private int data;
	private int goalCasa  ;
	private int goalTrasferta;
	private final String mode = "UPDATE";

	public PartitaUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Partita", null);
}
	}
	
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della partita:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci squadra1 della partita:");
			squadra1 = getInput();
			System.out.println("Inserisci squadra2 della partita:");
			squadra2 = getInput();
			System.out.println("Inserisci orario della partita:");
			orario = Integer.parseInt(getInput());
			System.out.println("Inserisci data della partita:");
			data = Integer.parseInt(getInput());
			System.out.println("Inserisci goal in casa della partita");
			goalCasa = Integer.parseInt(getInput());
			System.out.println("Inserisci goal in trasferta della partita");
			goalTrasferta = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("squadra1", squadra1);
		request.put("squadra2", squadra2);
		request.put("orario", orario);
		request.put("data", data);
		request.put("goalCasa", goalCasa);
		request.put("goalTraferta", goalTrasferta);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Partita", "doControl", request);
	}

}

