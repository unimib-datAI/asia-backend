package it.unimib.disco.asia.backend.controller;

import it.unimib.disco.asia.backend.repository.WeatherObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Weather {

	private final String[] CUMULATED_PARAMS = {"sf", "sund", "ssr", "tp"};

	@Autowired
	private WeatherObservationRepository weatherRepo;

	@RequestMapping(value = "weather", produces = "application/json")
	public String getWeather(@RequestParam(value = "ids") String idsList,
							 @RequestParam(value = "dates") String datesList,
							 @RequestParam(value = "weatherParams") String paramsList,
							 @RequestParam(value = "offsets") String offsetsList) throws Exception {

		String[] geoIdsStr = idsList.split(",");
		String[] dates = datesList.split(",");
		String[] weatherParams = paramsList.split(",");
		String[] weatherOffsetsStr = offsetsList.split(",");

        int[] geoIds = new int[geoIdsStr.length];
        for (int i = 0; i < geoIdsStr.length; ++i) {
            geoIds[i] = Integer.parseInt(geoIdsStr[i]);
        }

		int[] weatherOffsets = new int[weatherOffsetsStr.length];
		for (int i = 0; i < weatherOffsetsStr.length; ++i) {
			weatherOffsets[i] = Integer.parseInt(weatherOffsetsStr[i]);
		}

		Date[] datesISO = new Date[dates.length];
		for (int i = 0; i < dates.length; i++)
			datesISO[i] = new SimpleDateFormat("yyyy-MM-dd").parse(dates[i]);
		return weatherRepo.weatherQuery(geoIds, datesISO, this.CUMULATED_PARAMS, weatherParams, weatherOffsets).toString();
	}

}
