package com.testproj.mvc.controllers;

import com.testproj.mvc.services.AbstractService;

import java.util.List;


public abstract class AbstractController<T> {

	private AbstractService<T> service;

	public void setService(AbstractService<T> service) {
		this.service = service;
	}


	public T get(int id) {
		return service.getById(id);
	}

	public void create(T arg) {
		service.save(arg);
	}

	public void delete(int id) {
		service.delete(id);
	}

	public void update(T arg) {
		service.update(arg);
	}

	public List<T> getAll(){
		return service.getEntyties();
	}

}
