package com.testproj.mvc.controllers;


import com.testproj.mvc.model.Role;
import com.testproj.mvc.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public abstract class AbstractRoleController {

	@Autowired
	private RoleService service;


	public Role get(int id) {
		return service.getById(id);
	}

	public void create(Role role) {
		service.save(role);
	}

	public void delete(int id) {
		service.delete(id);
	}

	public void update(Role role) {
		service.update(role);
	}

	public List<Role> getAll(){
		return service.getRoles();
	}

}
