package com.example.demo.entity;
	
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Services {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long serviceid;
	
	@Column(name = "Type")
	private String type;
	

	@Column(name = "Validity")
	private String validity;
	
	@Column(name = "Fees")
	private String fee;
	
	@OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users;
	
	public Services() {
		
	}
	
	public Services(String type, String validity, String fee) {
		super();
		this.type = type;
		this.validity = validity;
		this.fee = fee;
	}
	
	public long getServiceid() {
		return serviceid;
	}

	public void setServiceid(long serviceid) {
		this.serviceid = serviceid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
}
