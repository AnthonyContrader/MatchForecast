package it.contrader.model;

import javax.persistence.*;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import it.dto.model.Match;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Historical {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idHistorical;
	@OneToOne
	@JoinColumn(name = "idHistoricaL", referencedColumnName= "id")
	private Match match;
	@Column(name = "risultato")
	private String risultato;
	
	
	
	
	


}
