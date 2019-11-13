package com.matchforecast.contrader.service.impl;

import com.matchforecast.contrader.service.HistoricalService;
import com.matchforecast.contrader.domain.Historical;
import com.matchforecast.contrader.repository.HistoricalRepository;
import com.matchforecast.contrader.service.dto.HistoricalDTO;
import com.matchforecast.contrader.service.mapper.HistoricalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Historical.
 */
@Service
@Transactional
public class HistoricalServiceImpl implements HistoricalService {

    private final Logger log = LoggerFactory.getLogger(HistoricalServiceImpl.class);

    private final HistoricalRepository historicalRepository;

    private final HistoricalMapper historicalMapper;

    public HistoricalServiceImpl(HistoricalRepository historicalRepository, HistoricalMapper historicalMapper) {
        this.historicalRepository = historicalRepository;
        this.historicalMapper = historicalMapper;
    }

    /**
     * Save a historical.
     *
     * @param historicalDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public HistoricalDTO save(HistoricalDTO historicalDTO) {
        log.debug("Request to save Historical : {}", historicalDTO);
        Historical historical = historicalMapper.toEntity(historicalDTO);
        historical = historicalRepository.save(historical);
        return historicalMapper.toDto(historical);
    }

    /**
     * Get all the historicals.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HistoricalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Historicals");
        return historicalRepository.findAll(pageable)
            .map(historicalMapper::toDto);
    }


    /**
     * Get one historical by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<HistoricalDTO> findOne(Long id) {
        log.debug("Request to get Historical : {}", id);
        return historicalRepository.findById(id)
            .map(historicalMapper::toDto);
    }

    /**
     * Delete the historical by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Historical : {}", id);
        historicalRepository.deleteById(id);
    }
}
