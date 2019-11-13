package com.matchforecast.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.matchforecast.contrader.domain.Schedina;
import com.matchforecast.contrader.repository.SchedinaRepository;
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
 * REST controller for managing Schedina.
 */
@RestController
@RequestMapping("/api")
public class SchedinaResource {

    private final Logger log = LoggerFactory.getLogger(SchedinaResource.class);

    private static final String ENTITY_NAME = "schedina";

    private final SchedinaRepository schedinaRepository;

    public SchedinaResource(SchedinaRepository schedinaRepository) {
        this.schedinaRepository = schedinaRepository;
    }

    /**
     * POST  /schedinas : Create a new schedina.
     *
     * @param schedina the schedina to create
     * @return the ResponseEntity with status 201 (Created) and with body the new schedina, or with status 400 (Bad Request) if the schedina has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/schedinas")
    @Timed
    public ResponseEntity<Schedina> createSchedina(@Valid @RequestBody Schedina schedina) throws URISyntaxException {
        log.debug("REST request to save Schedina : {}", schedina);
        if (schedina.getId() != null) {
            throw new BadRequestAlertException("A new schedina cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Schedina result = schedinaRepository.save(schedina);
        return ResponseEntity.created(new URI("/api/schedinas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /schedinas : Updates an existing schedina.
     *
     * @param schedina the schedina to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated schedina,
     * or with status 400 (Bad Request) if the schedina is not valid,
     * or with status 500 (Internal Server Error) if the schedina couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/schedinas")
    @Timed
    public ResponseEntity<Schedina> updateSchedina(@Valid @RequestBody Schedina schedina) throws URISyntaxException {
        log.debug("REST request to update Schedina : {}", schedina);
        if (schedina.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Schedina result = schedinaRepository.save(schedina);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, schedina.getId().toString()))
            .body(result);
    }

    /**
     * GET  /schedinas : get all the schedinas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of schedinas in body
     */
    @GetMapping("/schedinas")
    @Timed
    public List<Schedina> getAllSchedinas() {
        log.debug("REST request to get all Schedinas");
        return schedinaRepository.findAll();
    }

    /**
     * GET  /schedinas/:id : get the "id" schedina.
     *
     * @param id the id of the schedina to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the schedina, or with status 404 (Not Found)
     */
    @GetMapping("/schedinas/{id}")
    @Timed
    public ResponseEntity<Schedina> getSchedina(@PathVariable Long id) {
        log.debug("REST request to get Schedina : {}", id);
        Optional<Schedina> schedina = schedinaRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(schedina);
    }

    /**
     * DELETE  /schedinas/:id : delete the "id" schedina.
     *
     * @param id the id of the schedina to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/schedinas/{id}")
    @Timed
    public ResponseEntity<Void> deleteSchedina(@PathVariable Long id) {
        log.debug("REST request to delete Schedina : {}", id);

        schedinaRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
