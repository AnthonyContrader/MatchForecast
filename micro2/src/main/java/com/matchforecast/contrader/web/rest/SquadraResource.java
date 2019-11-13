package com.matchforecast.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.matchforecast.contrader.domain.Squadra;
import com.matchforecast.contrader.repository.SquadraRepository;
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
 * REST controller for managing Squadra.
 */
@RestController
@RequestMapping("/api")
public class SquadraResource {

    private final Logger log = LoggerFactory.getLogger(SquadraResource.class);

    private static final String ENTITY_NAME = "squadra";

    private final SquadraRepository squadraRepository;

    public SquadraResource(SquadraRepository squadraRepository) {
        this.squadraRepository = squadraRepository;
    }

    /**
     * POST  /squadras : Create a new squadra.
     *
     * @param squadra the squadra to create
     * @return the ResponseEntity with status 201 (Created) and with body the new squadra, or with status 400 (Bad Request) if the squadra has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/squadras")
    @Timed
    public ResponseEntity<Squadra> createSquadra(@Valid @RequestBody Squadra squadra) throws URISyntaxException {
        log.debug("REST request to save Squadra : {}", squadra);
        if (squadra.getId() != null) {
            throw new BadRequestAlertException("A new squadra cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Squadra result = squadraRepository.save(squadra);
        return ResponseEntity.created(new URI("/api/squadras/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /squadras : Updates an existing squadra.
     *
     * @param squadra the squadra to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated squadra,
     * or with status 400 (Bad Request) if the squadra is not valid,
     * or with status 500 (Internal Server Error) if the squadra couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/squadras")
    @Timed
    public ResponseEntity<Squadra> updateSquadra(@Valid @RequestBody Squadra squadra) throws URISyntaxException {
        log.debug("REST request to update Squadra : {}", squadra);
        if (squadra.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Squadra result = squadraRepository.save(squadra);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, squadra.getId().toString()))
            .body(result);
    }

    /**
     * GET  /squadras : get all the squadras.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of squadras in body
     */
    @GetMapping("/squadras")
    @Timed
    public List<Squadra> getAllSquadras() {
        log.debug("REST request to get all Squadras");
        return squadraRepository.findAll();
    }

    /**
     * GET  /squadras/:id : get the "id" squadra.
     *
     * @param id the id of the squadra to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the squadra, or with status 404 (Not Found)
     */
    @GetMapping("/squadras/{id}")
    @Timed
    public ResponseEntity<Squadra> getSquadra(@PathVariable Long id) {
        log.debug("REST request to get Squadra : {}", id);
        Optional<Squadra> squadra = squadraRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(squadra);
    }

    /**
     * DELETE  /squadras/:id : delete the "id" squadra.
     *
     * @param id the id of the squadra to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/squadras/{id}")
    @Timed
    public ResponseEntity<Void> deleteSquadra(@PathVariable Long id) {
        log.debug("REST request to delete Squadra : {}", id);

        squadraRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
