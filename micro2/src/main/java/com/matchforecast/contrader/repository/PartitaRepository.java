package com.matchforecast.contrader.repository;

import com.matchforecast.contrader.domain.Partita;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Partita entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PartitaRepository extends JpaRepository<Partita, Long> {

}
