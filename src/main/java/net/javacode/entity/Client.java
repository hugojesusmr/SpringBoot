package net.javacode.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdClient;
	private String FirstName;
	private String LastName;
	private String Phone;
	private String Email;
	@ManyToOne
	@JoinColumn(name = "idCity")
	private City IdCity;
	public Long getIdClient() {
		return IdClient;
	}
	public void setIdClient(Long idClient) {
		IdClient = idClient;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public City getIdCity() {
		return IdCity;
	}
	public void setIdCity(City idCity) {
		IdCity = idCity;
	}
	@Override
	public String toString() {
		return "Client [IdClient=" + IdClient + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Phone="
				+ Phone + ", Email=" + Email + ", IdCity=" + IdCity + "]";
	}
	
	
}
