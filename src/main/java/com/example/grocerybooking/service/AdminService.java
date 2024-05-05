package com.example.grocerybooking.service;

import java.util.List;

import com.example.grocerybooking.entity.Grocery;

public interface AdminService {
	
	public List<Grocery> getGroceries();

	public Grocery addgrocery(Grocery grocery);

	public Grocery updateGrocery(Grocery grocery);

	public void deleteGrocery(int id);

	public List<Grocery> findByCategory(String category);

}
