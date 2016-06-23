package com.testproj.mvc.controllers;

import com.testproj.mvc.services.UserToService;
import com.testproj.mvc.to.UserTo;
import com.testproj.mvc.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserToController {

	@Autowired
	private UserToService service;


	public UserTo get(int id) {
		return service.getTOById(id);
	}

	public void create(UserTo userTo) {
		service.save(UserUtil.prepareToSave(userTo));
	}

	public void delete(int id) {
		service.delete(id);
	}

	public void update(UserTo userTo, int id) {
		service.update(userTo, id);
	}

	public List<UserTo> getAll(){
		return service.getTOEntyties();
	}

}
