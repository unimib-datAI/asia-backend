package it.unimib.disco.asia.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.unimib.disco.asia.backend.model.WeatherObservation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unimib.disco.asia.backend.repository.WeatherObservationRepository;

@RestController
public class Weather {

	@Autowired
	private WeatherObservationRepository weatherRepo;

	@RequestMapping(value = "weather", produces = "application/json")
	public String getWeather(@RequestParam(value = "ids") String idsList,
							 @RequestParam(value = "dates") String datesList,
							 @RequestParam(value = "aggregators") String aggregatorsList,
							 @RequestParam(value = "weatherParams") String paramsList,
							 @RequestParam(value = "offsets") String offsetsList) throws Exception {

		String[] geoIdsStr = idsList.split(",");
		String[] dates = datesList.split(",");
		String[] weatherParams = paramsList.split(",");
		String[] weatherOffsetsStr = offsetsList.split(",");
		String[] aggregators = aggregatorsList.split(",");

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
		return weatherRepo.weatherQuery(geoIds, datesISO, aggregators, weatherParams, weatherOffsets).toString();
	}

}
