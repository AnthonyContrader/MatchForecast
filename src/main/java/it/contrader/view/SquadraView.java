package it.contrader.view;


import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SquadraDTO;
import it.contrader.main.MainDispatcher;
public class SquadraView extends AbstractView{
	

		private Request request;
		private String choice;

		public SquadraView() {
			
		}
		@Override
		public void showResults(Request request) {
			if (request != null) {
				System.out.println("\n------------------- Gestione Squadre ----------------\n");
				System.out.println("ID\tnomeSquadra\tnumGiocatori\tRating\tvittorieCasa\tvittorieEsterne\tsconfitteCasa\tsconfitteEsterne\tpareggiCasa\tpareggiEsterni");
				System.out.println("----------------------------------------------------\n");
				
				@SuppressWarnings("unchecked")
				List<SquadraDTO> squadre = (List<SquadraDTO>) request.get("squadre");
				for (SquadraDTO s: squadre)
					System.out.println(s);
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
			MainDispatcher.getInstance().callAction("Squadra", "doControl", this.request);
		}
}
