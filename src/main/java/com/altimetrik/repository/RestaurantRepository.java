package com.altimetrik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	@Query("select a from Restaurant a where a.destination <= :destination")
	List<Restaurant> findRestaurentByDestination(@Param("destination") Double destination);
}
