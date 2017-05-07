package com.restaurant.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.spring.DAO.RestaurantDAO;
import com.restaurant.spring.entity.NonVeg;
import com.restaurant.spring.entity.User;
import com.restaurant.spring.entity.Veg;

@Service
public class RestaurantServiceImp implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;
	
	@Override
	@Transactional
	public List<Veg> getAllVeg() {
		return restaurantDAO.getAllVeg();
	}

	@Override
	@Transactional
	public List<NonVeg> getAllNonVeg() {
		return restaurantDAO.getAllNonVeg();
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return restaurantDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		restaurantDAO.saveUser(user);
		
	}

	@Override
	@Transactional
	public User getUser(int id) {
		return restaurantDAO.getuser(id);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		restaurantDAO.deleteUser(id);
		
	}

	@Override
	@Transactional
	public void saveVeg(Veg veg) {
		restaurantDAO.saveVeg(veg);
		
	}

	@Override
	@Transactional
	public Veg getVeg(int id) {
		return restaurantDAO.getVeg(id);
	}

	@Override
	@Transactional
	public void deleteVeg(int id) {
		restaurantDAO.deleteVeg(id);
		
	}

	@Override
	@Transactional
	public void saveNonVeg(NonVeg nonVeg) {
		restaurantDAO.saveNonVeg(nonVeg);
		
	}

	@Override
	@Transactional
	public NonVeg getNonVeg(int id) {
		return restaurantDAO.getNonVeg(id);
	}

	@Override
	@Transactional
	public void deleteNonVeg(int id) {
		restaurantDAO.deleteNonVeg(id);
		
	}

	@Override
	@Transactional
	public boolean isVerified(User user) {
		return restaurantDAO.isVerified(user);
	}

	@Override
	@Transactional
	public boolean doesUserNameExist(User user) {
		return restaurantDAO.doesUserNameExist(user);
	}

	@Override
	@Transactional
	public boolean isAdmin(User user) {
		return restaurantDAO.isAdmin(user);
	}

}
