package com.testproj.mvc.services;

import com.testproj.mvc.LoggedUser;
import com.testproj.mvc.dao.RoleDao;
import com.testproj.mvc.dao.UserDao;
import com.testproj.mvc.model.Role;
import com.testproj.mvc.model.User;
import com.testproj.mvc.to.UserTo;
import com.testproj.mvc.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;


	@Override public void save(UserTo userTo) {
		User user = UserUtil.createFromUserTo(userTo);
		int chekRole = checkRoleName(user.getRole().getName());
		if (chekRole != 0){
			user.getRole().setId(chekRole);
		}
		userDao.save(user);
	}

	@Override public void delete(int id) {
		userDao.delete(id);
	}

	@Override public void update(UserTo userTo, int id) {
		userTo.setId(id);
		User user = UserUtil.updateFromUserTo(userTo);
		int chekRole = checkRoleName(user.getRole().getName());
		if (chekRole != 0){
			user.getRole().setId(chekRole);
		}
		userDao.save(user);
	}

	@Override public UserTo getById(int id) {
		return UserUtil.fromUser(userDao.getById(id));
	}

	@Override
	public List<UserTo> getUsers() {
		return UserUtil.list(userDao.getUsers());
	}

	@Override
	public void enable(int id, boolean enabled) {
		User user = UserUtil.updateFromUserTo(getById(id));
		user.setIsActive(enabled);
		userDao.save(user);
	}

	private int checkRoleName(String name){
		List<Role> roles = roleDao.getRoles();
		for (Role role: roles){
			if (role.getName().equalsIgnoreCase(name))
				return role.getId();
		}
		return 0;
	}

	@Override
	public LoggedUser loadUserByUsername(String name) throws UsernameNotFoundException {
		User u = userDao.getByName(name);
		if (u == null) {
			throw new UsernameNotFoundException("User " + name + " is not found");
		}
		return new LoggedUser(u);
	}
}
