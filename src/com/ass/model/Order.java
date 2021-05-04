package com.ass.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the favorites database table.
 * 
 */
@Entity
@Table(name="order")
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Order f")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favortiesId;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="ProductId")
	private Product product;

	public Order() {
	}

	public int getFavortiesId() {
		return favortiesId;
	}

	public void setFavortiesId(int favortiesId) {
		this.favortiesId = favortiesId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}

	

}