package com.example.grocerybooking.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.grocerybooking.dao.GroceryDao;
import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.service.AdminService;

@org.springframework.stereotype.Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private GroceryDao groceryDao;
	@Override
	public List<Grocery> getGroceries() {
		return groceryDao.findAll();
		
	}
	@Override
	public Grocery addgrocery(Grocery grocery) {
		return groceryDao.save(grocery);
		
	}
	@Override
	public Grocery updateGrocery(Grocery grocery) {
		return groceryDao.save(grocery);
	}
	
	@Override
	public void deleteGrocery(int id) {
	var entity = groceryDao.getOne(id);
       groceryDao.delete(entity);
       
	}
	@Override
	public List<Grocery> findByCategory(String category) {
		return groceryDao.findByCategory(category);
	}
	
	
	

}
