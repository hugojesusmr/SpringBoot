package net.javacode.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCity;
	private String City;
	
	
	public Long getIdCity() {
		return IdCity;
	}

	public void setIdCity(Long idCity) {
		IdCity = idCity;
	}
	
	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "City [IdCity=" + IdCity + ", City=" + City + "]";
	}
	
	
}
