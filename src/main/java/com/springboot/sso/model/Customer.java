package com.springboot.sso.model;

public class Customer {

	int id;

	String firstName;
	String lastName;
	String password;
	String zipcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Customer(String password, String firstName, String lastName) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {// overriding the toString() method
		return password + " " + firstName + " " + lastName;
	}
}
