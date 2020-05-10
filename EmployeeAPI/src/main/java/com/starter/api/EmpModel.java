package com.starter.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmpModel {

	private String name,email,country;
	
	@Id
	private int empId;
	
	
	public EmpModel() { }


	public EmpModel(int empId,String name, String email, String country) {
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.country = country;
	}
	
	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}	
}
