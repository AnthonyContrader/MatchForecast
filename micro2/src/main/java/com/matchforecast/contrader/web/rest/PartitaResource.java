package com.matchforecast.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.matchforecast.contrader.domain.Partita;
import com.matchforecast.contrader.repository.PartitaRepository;
import com.matchforecast.contrader.web.rest.errors.BadRequestAlertException;
import com.matchforecast.contrader.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Partita.
 */
@RestController
@RequestMapping("/api")
public class PartitaResource {

    private final Logger log = LoggerFactory.getLogger(PartitaResource.class);

    private static final String ENTITY_NAME = "partita";

    private final PartitaRepository partitaRepository;

    public PartitaResource(PartitaRepository partitaRepository) {
        this.partitaRepository = partitaRepository;
    }

    /**
     * POST  /partitas : Create a new partita.
     *
     * @param partita the partita to create
     * @return the ResponseEntity with status 201 (Created) and with body the new partita, or with status 400 (Bad Request) if the partita has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/partitas")
    @Timed
    public ResponseEntity<Partita> createPartita(@Valid @RequestBody Partita partita) throws URISyntaxException {
        log.debug("REST request to save Partita : {}", partita);
        if (partita.getId() != null) {
            throw new BadRequestAlertException("A new partita cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Partita result = partitaRepository.save(partita);
        return ResponseEntity.created(new URI("/api/partitas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /partitas : Updates an existing partita.
     *
     * @param partita the partita to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated partita,
     * or with status 400 (Bad Request) if the partita is not valid,
     * or with status 500 (Internal Server Error) if the partita couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/partitas")
    @Timed
    public ResponseEntity<Partita> updatePartita(@Valid @RequestBody Partita partita) throws URISyntaxException {
        log.debug("REST request to update Partita : {}", partita);
        if (partita.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Partita result = partitaRepository.save(partita);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, partita.getId().toString()))
            .body(result);
    }

    /**
     * GET  /partitas : get all the partitas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of partitas in body
     */
    @GetMapping("/partitas")
    @Timed
    public List<Partita> getAllPartitas() {
        log.debug("REST request to get all Partitas");
        return partitaRepository.findAll();
    }

    /**
     * GET  /partitas/:id : get the "id" partita.
     *
     * @param id the id of the partita to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the partita, or with status 404 (Not Found)
     */
    @GetMapping("/partitas/{id}")
    @Timed
    public ResponseEntity<Partita> getPartita(@PathVariable Long id) {
        log.debug("REST request to get Partita : {}", id);
        Optional<Partita> partita = partitaRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(partita);
    }

    /**
     * DELETE  /partitas/:id : delete the "id" partita.
     *
     * @param id the id of the partita to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/partitas/{id}")
    @Timed
    public ResponseEntity<Void> deletePartita(@PathVariable Long id) {
        log.debug("REST request to delete Partita : {}", id);

        partitaRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
