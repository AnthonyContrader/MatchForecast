package it.contrader.model;
import javax.persistence.*;

import it.contrader.model.Partita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Schedina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "idPartita", referencedColumnName= "id")
	private Partita partita;
	
	@Column
	private double quota1;
	
	private double quotaX;
	
	private double quota2;
	
	
}
