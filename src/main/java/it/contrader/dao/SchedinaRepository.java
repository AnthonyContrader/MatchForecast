package it.contrader.dao;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Schedina;

@Repository
@Transactional
public interface SchedinaRepository extends CrudRepository<Schedina,Long>{
	
	Schedina findSchedinaById(long id);

}
