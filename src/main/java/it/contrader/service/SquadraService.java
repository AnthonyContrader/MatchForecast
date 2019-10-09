package it.contrader.service;

import it.contrader.converter.SquadraConverter;
import it.contrader.dao.SquadraDAO;
import it.contrader.dto.SquadraDTO;
import it.contrader.model.Squadra;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class SquadraService extends AbstractService<Squadra, SquadraDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public SquadraService(){
		this.dao = new SquadraDAO();
		this.converter = new SquadraConverter();
	}
	

}

