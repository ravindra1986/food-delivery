package com.altimetrik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
