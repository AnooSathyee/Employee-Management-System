package com.myorg.ems.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Basic
	@NotBlank(message="First Name is required.")
	@Column(name = "first_name", length = 50)
	private String firstName;
	
	@Basic
	@NotBlank(message="Last Name is required.")
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Basic
	@Column(name = "date_of_birth")
	private String dob; 

	@Basic
	@NotNull(message = "Enter email")
	@Email(message = "Enter a valid email address.") 
	@Column(name = "email")
	private String email;

	/*@NotNull(message = "Enter password")
	@Size(min = 5, max = 15, message = "Enter valid password")
	@Column(name = "password")
	private String password;*/

	@Basic
	@Column(name = "gender")
	private String gender;
	
	@Basic
	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Basic
	@Column(name = "zipcode")
	private String zipcode;

	@Basic
	@Column(name = "state")
	private String state;

	@Basic
	@Column(name = "country")
	private String country;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String lastName, String dob, String email, String gender,
			String address, String city, String zipcode, String state, String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		//this.password = password;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
	}


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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", email=" + email + ", gender=" + gender + ", address=" + address + ", city=" + city + ", zipcode="
				+ zipcode + ", state=" + state + ", country=" + country + "]";
	}

}