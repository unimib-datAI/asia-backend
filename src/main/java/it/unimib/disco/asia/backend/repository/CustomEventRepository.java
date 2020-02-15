package it.unimib.disco.asia.backend.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import it.unimib.disco.asia.backend.model.customevent.CustomEvent;

public interface CustomEventRepository extends ArangoRepository<CustomEvent> {
}
