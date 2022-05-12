package com.tbs.theatre.dal.repository;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tbs.theatre.dal.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	@Query(value = "SELECT movie from Movie movie WHERE movie.name=:name")
	Movie findMovieByName(@Param(value = "name") String name);

	@Modifying
	@Transactional
	@org.springframework.data.jpa.repository.Query("UPDATE Movie movie SET movie.language=:language, movie.genre=:genre, movie.durationInMin=:duration,"
			+ " movie.releaseDate=:date WHERE movie.name=:name")
	public void update(@Param(value = "language") String language, @Param(value = "genre") String genre,
			@Param(value = "duration") int duration, @Param(value = "date") Date date, @Param(value = "name") String name);

}
