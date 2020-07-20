package com.altimetrik.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.model.Order;
import com.altimetrik.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/order")
public class FoodOrderingRestController {
@Autowired
private OrderRepository orRepo;
@GetMapping("/{id}")
public Optional<Order> findOrderById(@PathVariable("id") Long id) {
    return orRepo.findById(id);
}
@GetMapping("/")
public List<Order> getAllOrders() {
    return orRepo.findAll();
    
    
}
@PostMapping("/")
@ResponseStatus(HttpStatus.CREATED)
public void upload(@RequestBody Order order) {
	order.setOrderStatus("INITIATED");
	orRepo.save(order);
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable("id") Long id) {
	orRepo.deleteById(id);
}
@PutMapping("/{id}")
public Order updateOrderById(@PathVariable("id") Long id,@RequestBody final Order newOrder) {
	 return orRepo.findById(id)
		      .map(order -> {
		        order.setRestaurant(newOrder.getRestaurant());
		        order.setTotalPrice(newOrder.getTotalPrice());
		        order.setOrderStatus(newOrder.getOrderStatus());
		        return orRepo.save(order);
		      })
		      .orElseGet(() -> {
		    	  newOrder.setId(id);
		        return orRepo.save(newOrder);
		      });
}

@PutMapping("cancel/{id}")
public Order cancelOrderById(@PathVariable("id") Long id,@RequestBody final Order newOrder) {
	 return orRepo.findById(id)
		      .map(order -> {
		        
		        order.setOrderStatus("CANCEL");
		        return orRepo.save(order);
		      })
		      .orElseGet(() -> {
		    	  newOrder.setId(id);
		        return orRepo.save(newOrder);
		      });
}
}
