package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Forecast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codiceForecast;

	
	
	@Column(name = "id")
	private long id;
	@Column(name = "investimento")
	private float investimento;
	@Column(name = "guadagno")
	private float guadagno;
	@Column(name = "pRischio")
	private float pRischio;
	@Column(name = "wallet")
	private float wallet;
	@Column(name = "durata")
	private String durata;

}
