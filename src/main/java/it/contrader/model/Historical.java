package it.contrader.model;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import it.contrader.model.Partita;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Historical {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "idPartita", referencedColumnName= "id")
	private Partita partita;
	
	
	@Column
	private String result;
	
	
	
	
	


}
