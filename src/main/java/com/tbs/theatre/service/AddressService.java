package com.tbs.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.theatre.dal.entity.Address;
import com.tbs.theatre.dal.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getTheatreAddressByCity(String city) {
		return addressRepository.findAddressByCity(city);

	}

}
