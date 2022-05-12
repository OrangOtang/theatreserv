package com.tbs.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.theatre.dal.entity.Theatre;
import com.tbs.theatre.dal.repository.TheatreRepository;

@Service
public class TheatreService {

	@Autowired
	TheatreRepository theatreRepository;

	public List<List<Object[]>> getAllTheatre(String movieName, int movieid, List<Integer> addressIds, int showId) {
		return theatreRepository.findAllTheatres(movieName, movieid, addressIds, showId);

	}

	public List<Theatre> findTheatreByNameOrId(String theatreName, int theatreId) {
		return theatreRepository.findTheatreByNameOrId(theatreName, theatreId);
	}

	public void updateShowsInTheatres(List<Integer> theatreIds, List<Integer> showIds) {
		for (Integer theatreId : theatreIds) {
			for (Integer showId : showIds) {
				theatreRepository.updateShowsInTheatres(theatreId, showId);
			}
		}

	}

}
