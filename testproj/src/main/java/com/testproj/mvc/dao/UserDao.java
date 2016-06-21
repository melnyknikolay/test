package com.testproj.mvc.dao;

import com.testproj.mvc.model.User;

import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
public interface UserDao {
	void save(User user);
	void delete(int id);
	User getById(int id);
	User getByName(String name);
	List<User> getUsers();
}
