package com.altimetrik.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.Menu;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
	List<Menu> findByRestaurant_Id(Long id);

    void deleteByRestaurant_Id(Long id);
}
