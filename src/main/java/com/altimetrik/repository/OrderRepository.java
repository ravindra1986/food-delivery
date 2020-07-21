package com.altimetrik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
