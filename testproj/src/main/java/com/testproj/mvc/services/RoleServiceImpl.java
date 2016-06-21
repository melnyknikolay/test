package com.testproj.mvc.services;

import com.testproj.mvc.dao.AbstractRoleDao;
import com.testproj.mvc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Николай on 17.06.2016.
 */
@Service
public class RoleServiceImpl extends AbstractRoleService {

    @Autowired
    private AbstractRoleDao dao;

    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Role role) {
        dao.save(role);
    }

    @Override
    public Role getById(int id) {
        return dao.getById(id);
    }

    @Override
    public Role getByName(String name) {
        return dao.getByName(name);
    }


    @Override
    public List<Role> getEntyties() {
        return dao.getEntyties();
    }

}
