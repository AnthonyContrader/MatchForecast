package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDTO {
	

    private long codiceForecast;
    
	private long id;
	
	private float investimento;
	
	private float guadagno;
	
	private float pRischio;
	
	private float wallet;
	
	private String durata;
}
