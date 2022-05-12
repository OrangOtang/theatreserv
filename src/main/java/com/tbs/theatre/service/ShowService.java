package com.tbs.theatre.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.theatre.dal.entity.Show;
import com.tbs.theatre.dal.repository.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepository;

	public Show findShowByMovie(String name, LocalDate showDate, LocalTime showStartTime) {
		// TODO take care of multiple shows
		return showRepository.findShowByMovie(Date.valueOf(showDate), Time.valueOf(showStartTime), name);
	}

	public List<Integer> saveShows(int movieId, LocalDate showDate, List<LocalTime> showTimes) {
		List<Integer> showIds = new ArrayList<Integer>();
		for (LocalTime showTime : showTimes) {
			Show show = new Show();
			show.setMovieId(movieId);
			show.setShowDate(Date.valueOf(showDate));
			show.setStartTime(Time.valueOf(showTime));
			Show savedShow = showRepository.save(show);
			showIds.add(savedShow.getId());
		}

		return showIds;
	}

}
