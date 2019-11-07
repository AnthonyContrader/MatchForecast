package com.project.contrader.service.impl;

import com.project.contrader.service.InvestimentoService;
import com.project.contrader.domain.Investimento;
import com.project.contrader.repository.InvestimentoRepository;
import com.project.contrader.service.dto.InvestimentoDTO;
import com.project.contrader.service.mapper.InvestimentoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Investimento.
 */
@Service
@Transactional
public class InvestimentoServiceImpl implements InvestimentoService {

    private final Logger log = LoggerFactory.getLogger(InvestimentoServiceImpl.class);

    private final InvestimentoRepository investimentoRepository;

    private final InvestimentoMapper investimentoMapper;

    public InvestimentoServiceImpl(InvestimentoRepository investimentoRepository, InvestimentoMapper investimentoMapper) {
        this.investimentoRepository = investimentoRepository;
        this.investimentoMapper = investimentoMapper;
    }

    /**
     * Save a investimento.
     *
     * @param investimentoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public InvestimentoDTO save(InvestimentoDTO investimentoDTO) {
        log.debug("Request to save Investimento : {}", investimentoDTO);
        Investimento investimento = investimentoMapper.toEntity(investimentoDTO);
        investimento = investimentoRepository.save(investimento);
        return investimentoMapper.toDto(investimento);
    }

    /**
     * Get all the investimentos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<InvestimentoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Investimentos");
        return investimentoRepository.findAll(pageable)
            .map(investimentoMapper::toDto);
    }


    /**
     * Get one investimento by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<InvestimentoDTO> findOne(Long id) {
        log.debug("Request to get Investimento : {}", id);
        return investimentoRepository.findById(id)
            .map(investimentoMapper::toDto);
    }

    /**
     * Delete the investimento by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Investimento : {}", id);
        investimentoRepository.deleteById(id);
    }
}
