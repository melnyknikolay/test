package com.testproj.mvc.services;

import com.testproj.mvc.model.Role;
import com.testproj.mvc.model.User;
import com.testproj.mvc.to.UserTo;
import com.testproj.mvc.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
@Service
public class UserToService{

	@Autowired
	private AbstractService<Role> roleService;

	@Autowired
	private AbstractService<User> userService;


	public void save(UserTo userTo) {
		User user = UserUtil.createFromUserTo(userTo);
		Role role = roleService.save(user.getRole());
		if (role != null){
			user.setRole(role);
		}
		userService.save(user);
	}

	public void update(UserTo userTo, int id) {
		userTo.setId(id);
		User user = UserUtil.updateFromUserTo(userTo);
		Role role = roleService.getByName(user.getRole().getName());
		if (role != null){
			user.setRole(role);
		}
		userService.save(user);
	}

	public void delete(int id) {
		userService.delete(id);
	}

	public UserTo getTOById(int id) {
		return UserUtil.fromUser(userService.getById(id));
	}

	public UserTo getTOByName(String name) {
		return UserUtil.fromUser(userService.getByName(name));
	}

	public List<UserTo> getTOEntyties() {
		return UserUtil.list(userService.getEntyties());
	}

}
