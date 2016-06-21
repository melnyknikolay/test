package com.testproj.mvc.dao;

import com.testproj.mvc.model.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Николай on 17.06.2016.
 */
@Repository
public class RoleDaoImpl implements Dao<Role> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Role role) {
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        int checkName = checkRoleName(role.getName());
        if (checkName == 0){
            session.saveOrUpdate(role);
        }

    }

    @Override
    public void delete(int id) {
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        Role deletedRole = (Role) session.createQuery("from Role r where r.id = :id").setParameter("id", id).list().get(0);

        if (deletedRole != null){
            session.delete(deletedRole);
        }
    }

    @Override
    public Role getById(int id) {
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        Role role = (Role) session.createQuery("from Role r where r.id = :id").setParameter("id", id).list().get(0);
        return role;
    }



  @Override
    public Role getByName(String name) {
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        Role role = (Role) session.createQuery("from Role r where r.name = :name").setParameter("name", name).list().get(0);
        return role;
    }


   @Override
    public List<Role> getEntityes() {
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        List<Role> roles = session.createQuery("from Role").list();
        return roles;
    }


    public int checkRoleName(String name) {
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        List<Role> checkRole = session.createQuery("from Role r where r.name = :name").setParameter("name", name).list();
        if (checkRole.isEmpty()){
           return 0;
        }
        return checkRole.get(0).getId();
    }
}
