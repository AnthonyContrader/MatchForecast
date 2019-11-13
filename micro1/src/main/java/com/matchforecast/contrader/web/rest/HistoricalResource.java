package com.matchforecast.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.matchforecast.contrader.service.HistoricalService;
import com.matchforecast.contrader.web.rest.errors.BadRequestAlertException;
import com.matchforecast.contrader.web.rest.util.HeaderUtil;
import com.matchforecast.contrader.web.rest.util.PaginationUtil;
import com.matchforecast.contrader.service.dto.HistoricalDTO;
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
 * REST controller for managing Historical.
 */
@RestController
@RequestMapping("/api")
public class HistoricalResource {

    private final Logger log = LoggerFactory.getLogger(HistoricalResource.class);

    private static final String ENTITY_NAME = "historical";

    private final HistoricalService historicalService;

    public HistoricalResource(HistoricalService historicalService) {
        this.historicalService = historicalService;
    }

    /**
     * POST  /historicals : Create a new historical.
     *
     * @param historicalDTO the historicalDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new historicalDTO, or with status 400 (Bad Request) if the historical has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/historicals")
    @Timed
    public ResponseEntity<HistoricalDTO> createHistorical(@Valid @RequestBody HistoricalDTO historicalDTO) throws URISyntaxException {
        log.debug("REST request to save Historical : {}", historicalDTO);
        if (historicalDTO.getId() != null) {
            throw new BadRequestAlertException("A new historical cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HistoricalDTO result = historicalService.save(historicalDTO);
        return ResponseEntity.created(new URI("/api/historicals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /historicals : Updates an existing historical.
     *
     * @param historicalDTO the historicalDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated historicalDTO,
     * or with status 400 (Bad Request) if the historicalDTO is not valid,
     * or with status 500 (Internal Server Error) if the historicalDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/historicals")
    @Timed
    public ResponseEntity<HistoricalDTO> updateHistorical(@Valid @RequestBody HistoricalDTO historicalDTO) throws URISyntaxException {
        log.debug("REST request to update Historical : {}", historicalDTO);
        if (historicalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HistoricalDTO result = historicalService.save(historicalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, historicalDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /historicals : get all the historicals.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of historicals in body
     */
    @GetMapping("/historicals")
    @Timed
    public ResponseEntity<List<HistoricalDTO>> getAllHistoricals(Pageable pageable) {
        log.debug("REST request to get a page of Historicals");
        Page<HistoricalDTO> page = historicalService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/historicals");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /historicals/:id : get the "id" historical.
     *
     * @param id the id of the historicalDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the historicalDTO, or with status 404 (Not Found)
     */
    @GetMapping("/historicals/{id}")
    @Timed
    public ResponseEntity<HistoricalDTO> getHistorical(@PathVariable Long id) {
        log.debug("REST request to get Historical : {}", id);
        Optional<HistoricalDTO> historicalDTO = historicalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(historicalDTO);
    }

    /**
     * DELETE  /historicals/:id : delete the "id" historical.
     *
     * @param id the id of the historicalDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/historicals/{id}")
    @Timed
    public ResponseEntity<Void> deleteHistorical(@PathVariable Long id) {
        log.debug("REST request to delete Historical : {}", id);
        historicalService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
