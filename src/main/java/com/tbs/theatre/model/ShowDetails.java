package com.tbs.theatre.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "show")
public class ShowDetails {

	@JsonIgnore
	private BigInteger showId;
	private MovieInfo movie;
	private LocalDate showDate;
	private List<LocalTime> showTimes;
	private Auditorium auditorium;

	public BigInteger getShowId() {
		return showId;
	}

	public void setShowId(BigInteger showId) {
		this.showId = showId;
	}

	public MovieInfo getMovie() {
		return movie;
	}

	public void setMovie(MovieInfo movie) {
		this.movie = movie;
	}

	public List<LocalTime> getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(List<LocalTime> showTimes) {
		this.showTimes = showTimes;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

}
