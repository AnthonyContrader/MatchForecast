package com.matchforecast.contrader.repository;

import com.matchforecast.contrader.domain.Schedina;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Schedina entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SchedinaRepository extends JpaRepository<Schedina, Long> {

}
