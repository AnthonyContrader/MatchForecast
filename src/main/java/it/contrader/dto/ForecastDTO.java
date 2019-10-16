package it.contrader.dto;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDTO {
	

    private Long codiceForecast;
	private Long id;
	private float investimento;
	private float guadagno;
	private double pRischio;
	private float wallet;
	private LocalTime durata;
}
