package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ForecastConverter;
import it.contrader.dao.ForecastRepository;
import it.contrader.dto.ForecastDTO;
import it.contrader.model.Forecast;;

@Service
public class ForecastService extends AbstractService<Forecast, ForecastDTO> {

	@Autowired
	private ForecastConverter converter;
	@Autowired
	private ForecastRepository repository;

	public ForecastDTO findByCodiceForecast(long codiceForecast) {
		return converter.toDTO(repository.findByCodiceForecast(codiceForecast));
	}

}
