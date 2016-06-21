package com.testproj.mvc.services;

import java.util.List;


public interface Service<T> {
	void save(T arg);
	void delete(int id);
	void update(T arg);
	T getById(int id);
        T getByName(String name);
	List<T> getEntyties();
}
