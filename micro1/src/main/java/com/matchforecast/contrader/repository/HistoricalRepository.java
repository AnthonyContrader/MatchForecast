package com.matchforecast.contrader.repository;

import com.matchforecast.contrader.domain.Historical;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Historical entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HistoricalRepository extends JpaRepository<Historical, Long> {

}
