package com.altimetrik.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "order")
public class Order {

	@GeneratedValue
	@Id
	private Long id;
	private UserDetails userDetails;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	private double totalPrice;
	private String orderStatus;

	public Order() {
	}

	public Order(Long id, UserDetails userDetails, Restaurant restaurant, double totalPrice, String orderStatus) {
		super();
		this.id = id;
		this.userDetails = userDetails;
		this.restaurant = restaurant;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails
	 *            the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * @param restaurant
	 *            the restaurant to set
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		List<Menu> itemList = this.restaurant.getMenus();
		for (Menu menu : itemList) {
			List<MenuItem> menuItem = menu.getItems();
			for (MenuItem item : menuItem) {
				totalPrice += item.getPrice();
			}
		}
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus
	 *            the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", userDetails=" + userDetails + ", restaurant=" + restaurant + ", totalPrice="
				+ totalPrice + ", orderStatus=" + orderStatus + "]";
	}

}
