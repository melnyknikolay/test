package com.testproj.mvc.services;

import com.testproj.mvc.model.User;
import com.testproj.mvc.to.UserTo;

import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
public interface UserService {
	void save(UserTo userTo);
	void delete(int id);
	void update(UserTo userTo, int id);
	UserTo getById(int id);
	List<UserTo> getUsers();
	void enable(int id, boolean enabled);
}
