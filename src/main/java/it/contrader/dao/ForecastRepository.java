package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Forecast;

@Repository
@Transactional
public interface ForecastRepository extends CrudRepository<Forecast, Long> {

	Forecast findByCodiceForecast(long codiceForecast);

}