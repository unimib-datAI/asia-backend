package it.unimib.disco.asia.backend.repository;

import com.arangodb.springframework.annotation.Param;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import it.unimib.disco.asia.backend.model.Character;

public interface CharacterRepository extends ArangoRepository<Character> {
	 
	@Query("FOR c IN characters FILTER c.age > @age SORT c.age DESC RETURN c")
	Iterable<Character> getCharacters(@Param("age") int i);
}