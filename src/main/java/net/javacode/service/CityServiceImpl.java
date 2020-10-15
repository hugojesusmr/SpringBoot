package net.javacode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javacode.entity.City;
import net.javacode.repository.CityRepository;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	CityRepository cityRepository;
	
	@Override
	public List<City> listCities() {
		return (List<City>) cityRepository.findAll();
	}

}
