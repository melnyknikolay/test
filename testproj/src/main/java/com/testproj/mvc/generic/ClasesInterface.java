package com.testproj.mvc.generic;



import java.util.List;

/**
 * Created by DoctoRJurius on 16.06.16.
 */
public interface ClasesInterface<T> {
	void save(T arg);
	void delete(int id);
	T getById(int id);
	T getByName(String name);
	List<T> getEntyties();
}
