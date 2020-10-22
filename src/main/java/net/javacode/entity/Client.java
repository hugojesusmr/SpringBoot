package net.javacode.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idclient;
	@NotBlank(message = "You must specify the first name must be between 1 and 40")
    @Size(min=1, max=40)
	private String firstname;
	@NotBlank(message = "You must specify the last name must be between 1 and 40")
    @Size(min=2, max=40)
	private String lastname;
	@NotBlank(message = "You must specify the phone must be 9")
   	private String phone;
	@NotBlank
    @Email
	private String email;
	@ManyToOne
	@JoinColumn(name = "idcity")
	private City idcity;
	
	
	
	public Long getIdclient() {
		return idclient;
	}
	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public City getIdcity() {
		return idcity;
	}
	public void setIdcity(City idcity) {
		this.idcity = idcity;
	}
	
	
	
	
}
