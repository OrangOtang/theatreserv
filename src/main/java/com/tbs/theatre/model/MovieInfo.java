package com.tbs.theatre.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tbs.theatre.constants.Genre;

@XmlRootElement(name = "movie")
public class MovieInfo {

	@JsonIgnore
	private int movieId;
	private String movieName;
	private String movieLanguage;
	private Genre genre;
	private int durationInMin;
	private LocalDate releaseDate;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getDurationInMin() {
		return durationInMin;
	}

	public void setDurationInMin(int durationInMin) {
		this.durationInMin = durationInMin;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

}
