package com.testproj.mvc.services;

import com.testproj.mvc.dao.AbstractDao;

import java.util.List;

/**
 * Created by Николай on 21.06.2016.
 */
public abstract class AbstractService<T> {

   private AbstractDao<T> dao;

   public void setDao(AbstractDao<T> dao) {
      this.dao = dao;
   }


   public T save(T arg) {
     return dao.save(arg);
   }

   public void delete(int id) {
      dao.delete(id);
   }

   public T update(T arg) {
     return dao.save(arg);
   }

   public T getById(int id) {
      return dao.getById(id);
   }

   public T getByName(String name) {
      return dao.getByName(name);
   }

   public List<T> getEntyties() {
      return dao.getEntyties();
   }
}
