package com.altimetrik.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.model.Menu;

import java.util.List;
public interface MenuRepository extends JpaRepository<Menu, Long>{
	List<Menu> findByRestaurant_Id(Long id);

    void deleteByRestaurant_Id(Long id);
}
