package com.ass.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@Column(name = "username")
	private String username;
	@Column(name = "Email")
	private String email;

	@Column(name = "Fullname")
	private String fullname;
	@Column(name = "Admin")
	private boolean admin;


	@Column(name = "Password")
	private String password;


	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	

	public User() {
	}





	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public boolean isAdmin() {
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<Order> getOrders() {
		return orders;
	}



	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}





	

}