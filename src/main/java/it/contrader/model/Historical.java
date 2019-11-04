package it.contrader.model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	
	
	
	@ManyToOne (fetch=FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "idPartita", referencedColumnName= "id")
	private Partita partita;
	
	
	@Column
	private String result;
	
	
	
	
	


}
