package com.testproj.mvc.controllers;

import com.testproj.mvc.to.UserTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserRestController.REST_URL)
public class UserRestController extends AbstractUserController {
	public static final String REST_URL = "/rest/user";


	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserTo get(@PathVariable("id") int id) {
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody UserTo userTo) {
		super.create(userTo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		super.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody UserTo userTo, @PathVariable("id") int id) {
		super.update(userTo, id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserTo> getAll() {
		return super.getAll();
	}
}