package com.tbs.theatre.api.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tbs.theatre.api.TheatreActivities;
import com.tbs.theatre.constants.Genre;
import com.tbs.theatre.dal.entity.Address;
import com.tbs.theatre.dal.entity.Movie;
import com.tbs.theatre.dal.entity.Show;
import com.tbs.theatre.dal.entity.Theatre;
import com.tbs.theatre.exception.TheatreServiceException;
import com.tbs.theatre.model.AddressInfo;
import com.tbs.theatre.model.MovieInfo;
import com.tbs.theatre.model.ShowDetails;
import com.tbs.theatre.model.TheatreInfo;
import com.tbs.theatre.service.AddressService;
import com.tbs.theatre.service.MovieService;
import com.tbs.theatre.service.ShowService;
import com.tbs.theatre.service.TheatreService;

@RestController
public class TheatreActivitiesController implements TheatreActivities {

	@Autowired
	private TheatreService theatreService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private ShowService showService;
	@Autowired
	private MovieService movieService;

	@Override
	public List<TheatreInfo> getTheatres(String movieName, String town, String showDate, String showTime) {

		// TODO Call elastic search instead of DB to get Movies
		LocalDate showLocalDate = null;
		LocalTime showStartTime = null;
		if (StringUtils.isEmpty(movieName) || StringUtils.isEmpty(town) || StringUtils.isEmpty(showDate)
				|| StringUtils.isEmpty(showTime)) {

			throw new TheatreServiceException(HttpStatus.BAD_REQUEST, "Missing required input parameters");

		} else {
			showLocalDate = LocalDate.parse(showDate);
			showStartTime = LocalTime.parse(showTime);
		}
		Show showbyMovie = showService.findShowByMovie(movieName, showLocalDate, showStartTime);
		if(showbyMovie == null) {
			throw new TheatreServiceException(HttpStatus.NOT_FOUND, "This movie is not playing in any theatre for selected city and date time");
		}

		// TODO - AddressService should be another microservice component as it's a
		// cross cutting component
		List<Address> theatreAddress = addressService.getTheatreAddressByCity(town);
		List<Integer> addresses = theatreAddress.stream().map(a -> a.getId()).collect(Collectors.toList());

		List<TheatreInfo> theatres = new ArrayList<TheatreInfo>();
		List<List<Object[]>> theatreObjects = theatreService.getAllTheatre(movieName, showbyMovie.getMovieId(),
				addresses, showbyMovie.getId());
		this.mapToTheatreInfo(theatres, theatreObjects);

		return theatres;
	}

	@Override
	public ResponseEntity<String> saveShows(TheatreInfo theatre) {

		String theatreName = theatre.getTheatreName();
		int theatreId = 0;
		List<ShowDetails> showDetails = theatre.getShows();
		this.validateInput(theatreName, showDetails);

		List<Theatre> thteatres = theatreService.findTheatreByNameOrId(theatreName, theatreId);

		if (thteatres == null || thteatres.isEmpty()) {
			throw new TheatreServiceException(HttpStatus.NOT_FOUND,
					"This theatre is not registered. Register your theatre first.");
		}
		
		// NOTE: considering only one move show for simplicity
		MovieInfo movieInfo = showDetails.get(0).getMovie();
		
		Movie movie = movieService.findMovieByName(movieInfo.getMovieName());
		if (movie != null) {
			movieService.updateMovie(movieInfo);
		} else {
			Movie savedMovie = movieService.saveMovie(movieInfo);
			List<Integer> showIds = showService.saveShows(savedMovie.getId(), showDetails.get(0).getShowDate(), showDetails.get(0).getShowTimes());
			List<Integer> theatreIds = thteatres.stream().map(th -> th.getId()).collect(Collectors.toList());
			theatreService.updateShowsInTheatres(theatreIds, showIds);
		}
		return new ResponseEntity<String>("Show details saved", HttpStatus.CREATED);
	}

	private void validateInput(String theatreName, List<ShowDetails> showDetails) {
		if (StringUtils.isEmpty(theatreName)) {
			throw new TheatreServiceException(HttpStatus.BAD_REQUEST, "Theatre name is missing");
		}
		if (showDetails == null || showDetails.isEmpty() || showDetails.get(0).getMovie() == null
				|| showDetails.get(0).getShowDate() == null || showDetails.get(0).getShowTimes() == null) {
			throw new TheatreServiceException(HttpStatus.BAD_REQUEST, "Show and Movie information is required");
		}

	}

	private void mapToTheatreInfo(List<TheatreInfo> theatres, List<List<Object[]>> theatreObjects) {
		for (List<Object[]> objects : theatreObjects) {
			for (Object[] obj : objects) {
				TheatreInfo theatreInfo = new TheatreInfo();
				ShowDetails showDtls = new ShowDetails();
				for (Object inner : obj) {
					if (inner instanceof Theatre) {
						Theatre th = (Theatre) inner;
						theatreInfo.setTheatreId(th.getId());
						theatreInfo.setTheatreName(th.getName());
					}
					if (inner instanceof Address) {
						Address address = (Address) inner;
						AddressInfo addressInfo = new AddressInfo();
						addressInfo.setAddressId(address.getId());
						addressInfo.setLine1(address.getLine1());
						addressInfo.setLine2(address.getLine2());
						addressInfo.setCity(address.getCity());
						addressInfo.setState(address.getState());
						addressInfo.setPostalCode(address.getpostalCode());
						addressInfo.setCountryCode(address.getCountry());
						addressInfo.setPhoneNumber(address.getPhone());
						theatreInfo.setAddress(addressInfo);
					}
					if (inner instanceof Movie) {
						MovieInfo movieInfo = new MovieInfo();
						Movie movie = (Movie) inner;
						movieInfo.setMovieName(movie.getName());
						movieInfo.setMovieLanguage(movie.getLanguage());
						movieInfo.setGenre(Genre.valueOf(movie.getGenre()));
						movieInfo.setDurationInMin(movie.getDurationInMin());
						movieInfo.setReleaseDate(movie.getReleaseDate().toLocalDate());
						showDtls.setMovie(movieInfo);

					}
					if (inner instanceof Show) {
						Show show = (Show) inner;
						showDtls.setShowDate(show.getShowDate().toLocalDate());
						List<LocalTime> showTimes = (new ArrayList<LocalTime>());
						showTimes.add(show.getStartTime().toLocalTime());
						showDtls.setShowTimes(showTimes);
						List<ShowDetails> shows = new ArrayList<ShowDetails>();
						shows.add(showDtls);
						theatreInfo.setShows(shows);

					}
				}
				theatres.add(theatreInfo);

			}
		}
	}
}
