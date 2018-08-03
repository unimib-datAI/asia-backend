package it.unimib.disco.asia.backend.repository;

import com.arangodb.springframework.annotation.Param;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

import it.unimib.disco.asia.backend.model.Vincenzo;

public interface VincenzoRepository extends ArangoRepository<Vincenzo>{

	@Query("FOR c IN vincenzo FILTER ...inserisci filtri... RETURN c")
	Iterable<Vincenzo> customQuery(@Param("ids") String[] ids, @Param("dates") String[] dates, @Param("aggregator") String aggregator, @Param("params") String[] param, @Param("number") int number);
	
}
