package com.testproj.mvc.services;

import com.testproj.mvc.LoggedUser;
import com.testproj.mvc.dao.AbstractRoleDao;
import com.testproj.mvc.dao.AbstractUserDao;
import com.testproj.mvc.model.Role;
import com.testproj.mvc.model.User;
import com.testproj.mvc.to.UserTo;
import com.testproj.mvc.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
@Service("userService")
public class UserServiceImpl extends AbstractUserService implements UserDetailsService {

	@Autowired
	private AbstractUserDao userDao;

	@Autowired
	private AbstractRoleDao roleDao;


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
	public UserTo getByName(String name) {
		return UserUtil.fromUser(userDao.getByName(name));
	}

	@Override
	public List<UserTo> getEntyties() {
		return UserUtil.list(userDao.getEntyties());
	}

	@Override
	public void enable(int id, boolean enabled) {
		User user = UserUtil.updateFromUserTo(getById(id));
		user.setIsActive(enabled);
		userDao.save(user);
	}

	private int checkRoleName(String name){
		List<Role> roles = roleDao.getEntyties();
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
