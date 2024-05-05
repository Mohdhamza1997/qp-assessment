package com.example.grocerybooking.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocerybooking.dao.GroceryDao;
import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
    private GroceryDao groceryDao; 
    
    
	@Override
	public List<String> getGroceryNames() {
		return groceryDao.getGroecryNames();
	}


	@Override
	public Grocery getGroceryInfo(String grocery) {
		return groceryDao.findByName(grocery);
	}


	@Override
	public Double OrderdItems(List<String> groceries) {
		var grocieryList = String.join(",", groceries);
		return groceryDao.totalSumOFOrderedItems(grocieryList);
}
	

}
