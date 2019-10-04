package it.contrader.view.squadre;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
public class SquadraDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public SquadraDeleteView() {
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Squadra", null);
		}
	}@Override
	public void showOptions() {
		System.out.println("Inserisci id della squadra:");
		id = Integer.parseInt(getInput());

}

/**
 * impacchetta la request con l'id dell'utente da cancellare
 */
@Override
public void submit() {
	request = new Request();
	request.put("id", id);
	request.put("mode", mode);
	MainDispatcher.getInstance().callAction("Squadra", "doControl", request);
}


}
