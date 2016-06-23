package com.testproj.mvc.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Николай on 21.06.2016.
 */

public abstract class AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public T save(T arg) {
        Session session = getSession();
        session.saveOrUpdate(arg);
        return (T) session.merge(arg);
    }

    public void delete(int id) {
        Session session = getSession();
        T deletedEntity =  (T) session.createQuery(String.format("from %s r where r.id = :id", type)).setParameter("id", id).list().get(0);
        if (deletedEntity != null){
            session.delete(deletedEntity);
        }
    }

    public T getById(int id) {
        Session session = getSession();
        T entity = (T) session.createQuery(String.format("from %s r where r.id = :id", type)).setParameter("id", id).list().get(0);
        return entity;
    }


    public T getByName(String name) {
        Session session = getSession();
        T entity = (T) session.createQuery(String.format("from %s r where r.name = :name", type)).setParameter("name", name).list().get(0);
        return entity;
    }

    public List<T> getEntyties() {
        Session session = getSession();
        List<T> entyties = session.createQuery(String.format("from %s", type)).list();
        return entyties;
    }

    private Session getSession(){
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        return session;
    }
}
