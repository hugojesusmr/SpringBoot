package net.javacode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.javacode.entity.City;

public interface CityRepository extends CrudRepository<City, Long> {
	
}
