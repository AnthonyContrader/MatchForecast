package it.contrader.view.squadre;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SquadraUpdateView extends AbstractView{
	private Request request;

	private int id;
	private String nomeSquadra;
	private int numGiocatori;
	private float rating;
	private int vittorieCasa;
	private int vittorieEsterne;
	private int sconfitteCasa;
	private int sconfitteEsterne;
	private int pareggiCasa;
	private int pareggiEsterne;
	
	private final String mode = "UPDATE";
	
	public SquadraUpdateView() {
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Squadra", null);
		}
	}
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome della squadra:");
			nomeSquadra = getInput();
			System.out.println("Inserisci il numero di giocatori :");
			numGiocatori = Integer.parseInt(getInput());
			System.out.println("Inserisci il rating della squadra:");
			rating = Float.parseFloat(getInput());
			System.out.println("Inserisci le vittorie in casa :");
			vittorieCasa = Integer.parseInt(getInput());
			System.out.println("Inserisci le vittorie esterne :");
		    vittorieEsterne = Integer.parseInt(getInput());
			System.out.println("Inserisci le sconfitte in casa :");
			sconfitteCasa = Integer.parseInt(getInput());
			System.out.println("Inserisci le sconfitte esterne :");
			sconfitteEsterne = Integer.parseInt(getInput());
			System.out.println("inserisci i pareggi in casa :");
			pareggiCasa = Integer.parseInt(getInput());
			System.out.println("Inserisci i pareggi esterni :");
			pareggiEsterne = Integer.parseInt(getInput());
		} catch (Exception e) {

		}

}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("nomeSquadra", nomeSquadra);
		request.put("numGiocatori", numGiocatori);
		request.put("rating", rating);
		request.put("vittorieCasa", vittorieCasa);
		request.put("vittorieEsterne", vittorieEsterne);
		request.put("sconfitteCasa", sconfitteCasa);
		request.put("sconfitteEsterne", sconfitteEsterne);
		request.put("pareggiCasa", pareggiCasa);
		request.put("pareggiEsterni", pareggiEsterne);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Squadra", "doControl", request);
	}
}

