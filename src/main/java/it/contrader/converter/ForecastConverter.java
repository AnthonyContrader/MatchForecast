package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ForecastDTO;

import it.contrader.model.Forecast;

@Component
public class ForecastConverter extends AbstractConverter<Forecast, ForecastDTO> {

	@Override
	public Forecast toEntity(ForecastDTO forecastDTO) {
		Forecast forecast = null;
		if (forecastDTO != null) {
			forecast = new Forecast(forecastDTO.getCodiceForecast(),forecastDTO.getId(),forecastDTO.getInvestimento(),forecastDTO.getGuadagno(),forecastDTO.getPRischio(),forecastDTO.getWallet(),forecastDTO.getDurata());
			}
		return forecast;
	}

	@Override
	public ForecastDTO toDTO(Forecast forecast) {
		ForecastDTO forecastDTO = null;
		if (forecast != null) {
			forecastDTO = new ForecastDTO(forecast.getCodiceForecast(),forecast.getId(),forecast.getInvestimento(), forecast.getGuadagno(),forecast.getPRischio(),forecast.getWallet(),forecast.getDurata());

		}
		return forecastDTO;
	}
}