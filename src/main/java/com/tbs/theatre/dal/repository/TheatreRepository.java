package com.tbs.theatre.dal.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tbs.theatre.dal.entity.Theatre;
import com.tbs.theatre.exception.TheatreServiceException;

@Repository
public class TheatreRepository {
	@Autowired
	private EntityManager entityManager;

	public List<List<Object[]>> findAllTheatres(String movieName, int movieid, List<Integer> addressIds, int showId) {
		// TODO calling multiple times(as many times as number of addresses) is bad
		// approach. Use Hibernet SQL to use IN where caluse instead of fire same query
		// multiple times for different value of same addressId
		List<List<Object[]>> theatreSearchResult = new ArrayList<List<Object[]>>();
		Query query = entityManager.createQuery(
				"SELECT th, addr, movie, show from Theatre th, Address addr, Movie movie, Show show WHERE th.addressId=addr.id AND "
						+ "(th.show1=:movieid OR th.show2=:movieid OR th.show3=:movieid) AND th.addressId =:addressId AND show.id=:showId"
						+ " AND movie.name=:movieName");
		for (int addressId : addressIds) {
			query.setParameter("movieid", movieid);
			query.setParameter("showId", showId);
			query.setParameter("addressId", addressId);
			query.setParameter("movieName", movieName);
			try {
				List<Object[]> searchResult = query.getResultList();
				theatreSearchResult.add(searchResult);
			} catch (NoResultException ex) {
				continue;
			}
		}
		if (theatreSearchResult != null && theatreSearchResult.isEmpty()) {
			throw new TheatreServiceException(HttpStatus.NOT_FOUND,
					"No theatre found for slected movie name and  city");
		}

		return theatreSearchResult;

	}

	public List<Theatre> findTheatreByNameOrId(String theatreName, int theatreId) {
		Query query = entityManager.createQuery(
				"SELECT theatre from Theatre theatre where theatre.id=:theatreId OR theatre.name=:theatreName");
		query.setParameter("theatreId", theatreId);
		query.setParameter("theatreName", theatreName);
		List<Theatre> theatre = null;
		try {
			theatre = query.getResultList();
		} catch (NoResultException ex) {
			throw new TheatreServiceException(HttpStatus.NOT_FOUND,
					"This theatre is not registered. Register your theatre first.");
		}
		return theatre;

	}
	
	@Transactional
	public void updateShowsInTheatres(int theatreId, int showId) {
		Query upDateQuery = entityManager.createQuery("UPDATE Theatre th SET th.show1=:showId, th.show2=:showId, th.show3=:showId "
				+ "WHERE th.id=:theatreId");
		upDateQuery.setParameter("showId", showId);
		upDateQuery.setParameter("theatreId", theatreId);
		upDateQuery.executeUpdate();
		
	}
}
