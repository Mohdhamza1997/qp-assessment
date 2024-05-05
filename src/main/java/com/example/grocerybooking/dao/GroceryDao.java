package com.example.grocerybooking.dao;

import java.security.PublicKey;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grocerybooking.entity.Grocery;

public interface GroceryDao extends JpaRepository<Grocery, Integer> {
	
	
	public static final String Greocy_Name = "SELECT name FROM groceries";

	@org.springframework.data.jpa.repository.Query(value = Greocy_Name, nativeQuery = true)
	public List<String> getGroecryNames();
	
	
	public List<Grocery> findByCategory(String category);
	
	public Grocery findByName(String name); 
	
    @Query("SELECT sum(c.price) FROM groceries c WHERE c.name IN(:value)")
    Double totalSumOFOrderedItems(@Param("value") String value);
 
	
	

}
