package com.testproj.mvc.services;

import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
public interface Service<T> {
	void save(T arg);
	void delete(int id);
	void update(T arg);
	T getById(int id);
        T getByName(String name);
	List<T> getEntyties();
}
