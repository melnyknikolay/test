package com.testproj.mvc.dao;

import com.testproj.mvc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
@Repository
public class UserDaoImpl extends AbstractUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {

		Session session;
		try{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e){
			session = sessionFactory.openSession();
		}
		session.saveOrUpdate(user);
	}

	@Override
	public void delete(int id) {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e){
			session = sessionFactory.openSession();
		}
		User deletedUser = (User) session.createQuery("from User u where u.id = :id").setParameter("id", id).list().get(0);

		if (deletedUser != null){
			session.delete(deletedUser);
		}
	}

	@Override
	public User getById(int id) {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e){
			session = sessionFactory.openSession();
		}
		User user = (User) session.createQuery("from User u where u.id = :id").setParameter("id", id).list().get(0);

		return user;
	}

	@Override
	public User getByName(String name) {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e){
			session = sessionFactory.openSession();
		}
		User user = (User) session.createQuery("from User u where u.name = :name").setParameter("name", name).list().get(0);

		return user;
	}

	@Override
	public List<User> getEntyties() {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e){
			session = sessionFactory.openSession();
		}
		List<User> userList = session.createQuery("from User").list();
		return userList;
	}
}
