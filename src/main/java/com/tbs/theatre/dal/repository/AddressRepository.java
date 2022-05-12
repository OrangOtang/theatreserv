package com.tbs.theatre.dal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tbs.theatre.dal.entity.Address;

@Repository
public class AddressRepository {

	@Autowired
	EntityManager entityManager;

	public List<Address> findAddressByCity(String city) {

		Query selectByCityQuery = entityManager
				.createQuery("SELECT address from Address address where address.city=:city");
		selectByCityQuery.setParameter("city", city);
		return  (List<Address>) selectByCityQuery.getResultList();
	}

}
