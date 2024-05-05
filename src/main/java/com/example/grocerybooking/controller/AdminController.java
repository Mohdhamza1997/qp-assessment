package com.example.grocerybooking.controller;

import java.util.List;
import java.util.function.LongFunction;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	

//list of groceryInfo	
	
@GetMapping("/groceries")
public List<Grocery> getGroceries(){
	var groceries = service.getGroceries();
	return groceries;
	
}

//add new grocery info

@PostMapping("/grocery/add")
public Grocery addGrocery(@RequestBody Grocery grocery) {
	return service.addgrocery(grocery);
}


//update the grocery info 

@PutMapping("/grocery/update")
public Grocery updateGrocery(@RequestBody Grocery grocery) {
	return service.updateGrocery(grocery);	
}

// delete the grocery

@DeleteMapping("/grocery/delete/{id}")
public ResponseEntity<HttpStatus> deleteGrocery(@PathVariable String id){
	try {
		this.service.deleteGrocery(Integer.parseInt(id));
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);					
     }
}

//get grocery by category

@GetMapping("/groceries/byCategory/{category}")
public List<Grocery> findByCategory(@PathVariable String category){
	var groceriesByCategory = service.findByCategory(category);
	return groceriesByCategory;
	
}


}

