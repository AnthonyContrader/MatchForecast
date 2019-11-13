package com.matchforecast.contrader.service;

import com.matchforecast.contrader.service.dto.InvestimentoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Investimento.
 */
public interface InvestimentoService {

    /**
     * Save a investimento.
     *
     * @param investimentoDTO the entity to save
     * @return the persisted entity
     */
    InvestimentoDTO save(InvestimentoDTO investimentoDTO);

    /**
     * Get all the investimentos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<InvestimentoDTO> findAll(Pageable pageable);


    /**
     * Get the "id" investimento.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<InvestimentoDTO> findOne(Long id);

    /**
     * Delete the "id" investimento.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

   // List<InvestimentoDTO> getUserInvestimentos(Long iduser);


}
