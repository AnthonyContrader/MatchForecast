package it.contrader.model;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	
	@ManyToOne
	@JoinColumn(name = "idMatch", referencedColumnName= "id")
	private Match match;
	
	
	@Column
	private String result;
	
	
	
	
	


}
