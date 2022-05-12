package com.tbs.theatre.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tbs.theatre.model.TheatreInfo;

@RequestMapping("/tbs/v1")
public interface TheatreActivities {
	@GetMapping(value = "/theatres", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TheatreInfo> getTheatres(@RequestParam("movieName") String movieName, @RequestParam("town") String town,
			@RequestParam("showDate") String showDate, @RequestParam("showTime") String showTime);

	@PutMapping(value = "/theatre/shows", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveShows(@RequestBody TheatreInfo theatre);

}
