package com.project.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.project.contrader.service.InvestimentoService;
import com.project.contrader.web.rest.errors.BadRequestAlertException;
import com.project.contrader.web.rest.util.HeaderUtil;
import com.project.contrader.web.rest.util.PaginationUtil;
import com.project.contrader.service.dto.InvestimentoDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Investimento.
 */
@RestController
@RequestMapping("/api")
public class InvestimentoResource {

    private final Logger log = LoggerFactory.getLogger(InvestimentoResource.class);

    private static final String ENTITY_NAME = "investimento";

    private final InvestimentoService investimentoService;

    public InvestimentoResource(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    /**
     * POST  /investimentos : Create a new investimento.
     *
     * @param investimentoDTO the investimentoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new investimentoDTO, or with status 400 (Bad Request) if the investimento has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/investimentos")
    @Timed
    public ResponseEntity<InvestimentoDTO> createInvestimento(@Valid @RequestBody InvestimentoDTO investimentoDTO) throws URISyntaxException {
        log.debug("REST request to save Investimento : {}", investimentoDTO);
        if (investimentoDTO.getId() != null) {
            throw new BadRequestAlertException("A new investimento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InvestimentoDTO result = investimentoService.save(investimentoDTO);
        return ResponseEntity.created(new URI("/api/investimentos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /investimentos : Updates an existing investimento.
     *
     * @param investimentoDTO the investimentoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated investimentoDTO,
     * or with status 400 (Bad Request) if the investimentoDTO is not valid,
     * or with status 500 (Internal Server Error) if the investimentoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/investimentos")
    @Timed
    public ResponseEntity<InvestimentoDTO> updateInvestimento(@Valid @RequestBody InvestimentoDTO investimentoDTO) throws URISyntaxException {
        log.debug("REST request to update Investimento : {}", investimentoDTO);
        if (investimentoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        InvestimentoDTO result = investimentoService.save(investimentoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, investimentoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /investimentos : get all the investimentos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of investimentos in body
     */
    @GetMapping("/investimentos")
    @Timed
    public ResponseEntity<List<InvestimentoDTO>> getAllInvestimentos(Pageable pageable) {
        log.debug("REST request to get a page of Investimentos");
        Page<InvestimentoDTO> page = investimentoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/investimentos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /investimentos/:id : get the "id" investimento.
     *
     * @param id the id of the investimentoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the investimentoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/investimentos/{id}")
    @Timed
    public ResponseEntity<InvestimentoDTO> getInvestimento(@PathVariable Long id) {
        log.debug("REST request to get Investimento : {}", id);
        Optional<InvestimentoDTO> investimentoDTO = investimentoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(investimentoDTO);
    }

    /**
     * DELETE  /investimentos/:id : delete the "id" investimento.
     *
     * @param id the id of the investimentoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/investimentos/{id}")
    @Timed
    public ResponseEntity<Void> deleteInvestimento(@PathVariable Long id) {
        log.debug("REST request to delete Investimento : {}", id);
        investimentoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
