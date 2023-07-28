package com.example.demo.entity;
	
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
//	@Column(name = "service_number")
//	private String service_Number;
	
	@ManyToOne
	@JoinColumn(name="service_number", referencedColumnName="serviceid")
	private Services services;


	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, Services services) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.services = services;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}
	
//	public String getService_Number() {
//		return service_Number;
//	}
//
//	public void setService_Number(String service_Number) {
//		this.service_Number = service_Number;
//	}
}