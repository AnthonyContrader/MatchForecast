package com.project.contrader.repository;

import com.project.contrader.domain.Investimento;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Investimento entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

}
