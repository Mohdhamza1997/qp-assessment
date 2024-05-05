package com.example.grocerybooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//list of grocery
	
	@GetMapping("/groceries")
	public List<String> getGroceryNames(){
		var groceryName = service.getGroceryNames();
		return groceryName;
		
	}
	
	// info of grocery
	
	@GetMapping("/groceries/{grocery}")
	public Grocery getGroceryInfo(@PathVariable String grocery){
		var groceryInfo = service.getGroceryInfo(grocery);
		return groceryInfo;
		
	}
	
	//get total sum of ordered grocery
	
	@PostMapping("/groceries/order")
	public Double OrderdItems(@RequestBody List<String> groceries) {
		var totalSum = service.OrderdItems(groceries);
		return totalSum;
		
}

}
