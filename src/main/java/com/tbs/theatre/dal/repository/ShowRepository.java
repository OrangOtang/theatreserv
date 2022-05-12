package com.tbs.theatre.dal.repository;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tbs.theatre.dal.entity.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Integer> {

	@Query(value = "SELECT show from Movie movie, Show show WHERE show.showDate=:sqlShowDate AND show.startTime "
			+ "=:sqlStartTime AND movie.name=:name AND show.movieId=movie.id")
	Show findShowByMovie(@Param(value = "sqlShowDate") Date sqlShowDate, @Param(value="sqlStartTime") Time startTime,
			@Param(value="name") String name);

}
