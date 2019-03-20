package com.evrybank;

public class Customer {

	 private String firstname;
	 private String lastname;
	 private String city;
	 private String location;
	 
	 
	public Customer(String firstname, String lastname, String city, String location) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.location = location;
	}
	public Customer() {
		super();
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 
	 
}
