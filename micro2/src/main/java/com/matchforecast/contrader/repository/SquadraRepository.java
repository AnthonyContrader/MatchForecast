package com.matchforecast.contrader.repository;

import com.matchforecast.contrader.domain.Squadra;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Squadra entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SquadraRepository extends JpaRepository<Squadra, Long> {

}
