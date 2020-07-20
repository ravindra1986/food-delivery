package com.altimetrik.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.model.MenuItem;

import java.util.List;
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{
	List<MenuItem> findByMenu_Id(Long id);
}
