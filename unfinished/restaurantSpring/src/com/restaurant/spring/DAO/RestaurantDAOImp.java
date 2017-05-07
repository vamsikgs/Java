package com.restaurant.spring.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.spring.entity.NonVeg;
import com.restaurant.spring.entity.User;
import com.restaurant.spring.entity.Veg;

@Repository
public class RestaurantDAOImp implements RestaurantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Veg> getAllVeg() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Veg", Veg.class).getResultList();
	}

	@Override
	public List<NonVeg> getAllNonVeg() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from NonVeg", NonVeg.class).getResultList();
	}

	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from User", User.class).getResultList();
	}

	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}

	@Override
	public User getuser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		currentSession.delete(user);
	}

	@Override
	public void saveVeg(Veg veg) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(veg);
	}

	@Override
	public Veg getVeg(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Veg veg = currentSession.get(Veg.class, id);
		return veg;
	}

	@Override
	public void deleteVeg(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Veg veg = currentSession.get(Veg.class, id);
		currentSession.delete(veg);
	}

	@Override
	public void saveNonVeg(NonVeg nonVeg) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(nonVeg);
	}

	@Override
	public NonVeg getNonVeg(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		NonVeg nonVeg = currentSession.get(NonVeg.class, id);
		return nonVeg;
	}

	@Override
	public void deleteNonVeg(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		NonVeg nonVeg = currentSession.get(NonVeg.class, id);
		currentSession.delete(nonVeg);
	}

	@Override
	public boolean isVerified(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> query = currentSession
				.createQuery("from User u where u.userName = :userName and u.password = :password ");
		query.setParameter("userName", user.getUserName());
		query.setParameter("password", user.getPassword());
		List<?> result = query.list();
		if ((result != null) && (result.size() > 0)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean doesUserNameExist(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> query = currentSession.createQuery("from User u where u.userName = :userName ");
		User user1 = (User) query.setParameter("userName", user.getUserName()).uniqueResult();
		if (user1 != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean isAdmin(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> query = currentSession.createQuery("from User u where u.userName = :userName and u.type = 'admin' ");
		List<?> list = query.setParameter("userName", user.getUserName()).getResultList();
		if ((list != null) && (list.size()>0))
			return true;
		else
			return false;
	}
}