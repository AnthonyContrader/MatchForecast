package it.contrader.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Forecast {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long codiceForecast;
	
	@ManyToOne
	@JoinColumn(name="id")
	@Column
	private Long id;
	private float investimento;
	private float guadagno;
	private double pRischio;
	private float wallet;
	private LocalTime durata;
	

}
