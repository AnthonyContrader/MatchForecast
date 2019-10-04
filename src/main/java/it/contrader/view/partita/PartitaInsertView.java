package it.contrader.view.partita;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PartitaInsertView extends AbstractView  {
	
	private Request request;

	private String squadra1;
	private String squadra2;
	private int orario;
	private int data;
	private String risultato;
	private final String mode = "INSERT";

	public PartitaInsertView() {
	
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Partita", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci squadra1 della partita:");
			squadra1 = getInput();
			System.out.println("Inserisci squadra2 della partita:");
			squadra2 = getInput();
			System.out.println("Inserisci orario della partita:");
			orario = Integer.parseInt(getInput());
			System.out.println("Inserisci data della partita:");
			data = Integer.parseInt(getInput());
			System.out.println("Inserisci risultato della partita:");
			risultato = getInput();
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("squadra1", squadra1);
		request.put("squadra2", squadra2);
		request.put("orario", orario);
		request.put("data", data);
		request.put("risultato", risultato);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Partita", "doControl", request);
	}



}
