package com.altimetrik.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.MenuItem;

import java.util.List;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{
	List<MenuItem> findByMenu_Id(Long id);
}
