package com.matchforecast.contrader.service;

import com.matchforecast.contrader.service.dto.HistoricalDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Historical.
 */
public interface HistoricalService {

    /**
     * Save a historical.
     *
     * @param historicalDTO the entity to save
     * @return the persisted entity
     */
    HistoricalDTO save(HistoricalDTO historicalDTO);

    /**
     * Get all the historicals.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HistoricalDTO> findAll(Pageable pageable);


    /**
     * Get the "id" historical.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<HistoricalDTO> findOne(Long id);

    /**
     * Delete the "id" historical.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
