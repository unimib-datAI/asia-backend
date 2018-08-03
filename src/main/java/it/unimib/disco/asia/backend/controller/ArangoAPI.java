package it.unimib.disco.asia.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unimib.disco.asia.backend.model.Character;

import com.arangodb.springframework.core.ArangoOperations;

import it.unimib.disco.asia.backend.repository.CharacterRepository;
import it.unimib.disco.asia.backend.repository.VincenzoRepository;

@RestController
public class ArangoAPI {
	@Autowired
	private ArangoOperations operations;
	@Autowired
	private CharacterRepository characterRepo;
	@Autowired
	private VincenzoRepository vincenzoRepo;

	@RequestMapping(value = "arango/create", produces = "application/json")
	public String create() {
		operations.dropDatabase();

		Character renzo = new Character("Renzo", "Alva", true, 26);
		Character fabio = new Character("Fabio", "Alva", true, 33);
		Character cecilia = new Character("Cecilia", "Principe", true, 60);
		Character aquiles = new Character("Aquiles", "Alva", true, 65);

		characterRepo.save(renzo);
		characterRepo.save(fabio);
		characterRepo.save(cecilia);
		characterRepo.save(aquiles);

		return "{\"message\": \"done\"}";

	}

	
	@RequestMapping(value = "arango/get", produces = "application/json")
	public String get(@RequestParam(value = "age") int age) {
		return characterRepo.getCharacters(age).toString();
	}

	
	@RequestMapping(value = "arango/query", produces = "application/json")
	public String getCustom(@RequestParam(value = "ids") String ids,
			@RequestParam(value = "dates") String dateList,
			@RequestParam(value = "aggregator") String aggregator,
			@RequestParam(value = "moreParams") String moreParameters,
			@RequestParam(value = "number") int number) throws Exception {
		
		String[] geoIds = ids.split(",");
		String[] dates = dateList.split(",");
		String[] moreParams = moreParameters.split(",");

		Date[] datesISO = new Date[dates.length];
		for (int i = 0; i < dates.length; i++)
			datesISO[i] = new SimpleDateFormat("yyyy-MM-dd").parse(dates[i]);
		return vincenzoRepo.customQuery(geoIds, dates, aggregator, moreParams, number).toString();
	}

}
