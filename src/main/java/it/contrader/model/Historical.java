package it.contrader.model;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import it.contrader.model.Match;

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
	@Column(name = "result")
	private String result;
	
	
	
	
	


}
