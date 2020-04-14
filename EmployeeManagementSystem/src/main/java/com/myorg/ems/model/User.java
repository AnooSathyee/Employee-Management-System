package com.myorg.ems.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = ?1")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Basic
	@NotNull(message = "Enter name")
	private String name;
	
	@NotNull(message = "Enter email")
	@Email(message = "Enter a valid email address.") 
	private String email;
	
	@Basic
	@NotNull(message = "Enter password")
	private String password;
	
	public User() {}
	
	public User(String name, String email, String password) {
		this.name =name;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}

