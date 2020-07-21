package com.altimetrik.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "restaurant")
public class Restaurant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2942752986520809285L;

	@GeneratedValue
	@Id
	private Long id;

	private String name;

	private String location;

	private double rating;

	private long deatination;

	@JsonManagedReference
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Menu> menus;

	@JsonManagedReference
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Order> orders;

	public Restaurant() {
	}

	public Restaurant(Long id, String name, String location, double rating, long deatination, List<Menu> menus,
			List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.deatination = deatination;
		this.menus = menus;
		this.orders = orders;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", rating=" + rating
				+ ", deatination=" + deatination + ", menus=" + menus + "]";
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the deatination
	 */
	public long getDeatination() {
		return deatination;
	}

	/**
	 * @param deatination
	 *            the deatination to set
	 */
	public void setDeatination(long deatination) {
		this.deatination = deatination;
	}

	/**
	 * @return the menus
	 */
	public List<Menu> getMenus() {
		return menus;
	}

	/**
	 * @param menus
	 *            the menus to set
	 */
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
