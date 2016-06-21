package com.testproj.mvc.services;

import com.testproj.mvc.model.Role;

import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
public interface RoleService {
	void save(Role role);
	void delete(int id);
	void update(Role role);
	Role getById(int id);
	List<Role> getRoles();
}
