package com.testproj.mvc.controllers;


import com.testproj.mvc.model.Role;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RoleRestController.REST_URL)
public class RoleRestController extends AbstractRoleController {
	public static final String REST_URL = "/rest/role";


	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Role get(@PathVariable("id") int id) {
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Role role) {
		super.create(role);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		super.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Role role, @PathVariable("id") int id) {
		super.update(role);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Role> getAll() {
		return super.getAll();
	}
}