package com.tbs.theatre.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.theatre.dal.entity.Movie;
import com.tbs.theatre.dal.repository.MovieRepository;
import com.tbs.theatre.model.MovieInfo;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie findMovieByName(String name) {
		return movieRepository.findMovieByName(name);
	}

	public Movie saveMovie(MovieInfo movieInfo) {
		Movie movie = new Movie();
		movie.setName(movieInfo.getMovieName());
		movie.setLanguage(movieInfo.getMovieLanguage());
		movie.setGenre(movieInfo.getGenre().name());
		movie.setDurationInMin(movieInfo.getDurationInMin());
		movie.setReleaseDate(Date.valueOf(movieInfo.getReleaseDate()));
		return movieRepository.save(movie);
	}

	public void updateMovie(MovieInfo movieInfo) {
		movieRepository.update(movieInfo.getMovieLanguage(), movieInfo.getGenre().name(), movieInfo.getDurationInMin(),
				Date.valueOf(movieInfo.getReleaseDate()), movieInfo.getMovieName());
	}

}
