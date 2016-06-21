package com.testproj.mvc.services;

import com.testproj.mvc.dao.RoleDao;
import com.testproj.mvc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Николай on 17.06.2016.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void delete(int id) {
        roleDao.delete(id);
    }

    @Override
    public void update(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getById(int id) {
        return roleDao.getById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

}
