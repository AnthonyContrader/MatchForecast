package it.contrader.dao;





import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Match;

@Repository
@Transactional
public interface MatchRepository extends CrudRepository<Match,Long> {
	
	Match findByIdMatch(long idMatch);

}
