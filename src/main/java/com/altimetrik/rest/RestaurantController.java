package com.altimetrik.rest;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.altimetrik.model.Menu;
import com.altimetrik.model.Restaurant;
import com.altimetrik.repository.MenuRepository;
import com.altimetrik.repository.RestaurantRepository;
public class RestaurantController {
	 @Autowired
	    private RestaurantRepository cr;

	    @Autowired
	    private MenuRepository mr;

	    @RequestMapping("/")
	    public List<Restaurant> getRestaurants() {
	        List<Restaurant> restaurants = cr.findAll();
	        return restaurants;
	    }

	    @RequestMapping("/{id}")
	    public Optional<Restaurant> findRestaurantById(@PathVariable("id") Long id) {
	        return cr.findById(id);
	    }

	    @PostMapping("/")
	    @ResponseStatus(HttpStatus.CREATED)
	    public void upload(@RequestBody List<Restaurant> restaurants) {
	        cr.saveAll(restaurants);
	    }

	    @DeleteMapping("/")
	    public void deleteAll() {
	        cr.deleteAll();
	    }

	    @DeleteMapping("/{id}")
	    public void deleteById(@PathVariable("id") Long id) {
	        cr.deleteById(id);
	    }

	    @RequestMapping("/{id}/menus/")
	    public List<Menu> getMenus(@PathVariable("id") Long id) {
	        Optional<Restaurant> rest = cr.findById(id);
	        if (rest != null)
	            return mr.findByRestaurant_Id(id);
	        return new LinkedList<Menu>();
	    }
	    @GetMapping("/{destination}")
	    public List<Restaurant> findRestaurantByDestination(@PathVariable("destination") Double destination) {
	        return cr.findRestaurentByDestination(destination);
	    }
	    
}
