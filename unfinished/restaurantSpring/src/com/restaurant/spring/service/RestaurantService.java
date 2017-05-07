package com.restaurant.spring.service;

import java.util.List;

import com.restaurant.spring.entity.NonVeg;
import com.restaurant.spring.entity.User;
import com.restaurant.spring.entity.Veg;

public interface RestaurantService{
	
	public List<Veg> getAllVeg();

	public List<NonVeg> getAllNonVeg();

	public List<User> getUsers();

	public void saveUser(User user);

	public User getUser(int id);

	public void deleteUser(int id);

	public void saveVeg(Veg veg);

	public Veg getVeg(int id);

	public void deleteVeg(int id);

	public void saveNonVeg(NonVeg nonVeg);

	public NonVeg getNonVeg(int id);

	public void deleteNonVeg(int id);

	public boolean isVerified(User user);

	public boolean doesUserNameExist(User user);

	public boolean isAdmin(User user);
}