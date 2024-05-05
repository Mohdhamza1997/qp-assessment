package com.example.grocerybooking.service;

import java.util.List;

import com.example.grocerybooking.entity.Grocery;

public interface UserService {

	public List<String> getGroceryNames();

	public Grocery getGroceryInfo(String grocery);

	public Double OrderdItems(List<String> groceries);

}
