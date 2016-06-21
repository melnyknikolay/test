package com.testproj.mvc.dao;

import com.testproj.mvc.model.Role;

import java.util.List;


public interface RoleDao {
    void save(Role role);
    void delete(int id);
    Role getById(int id);
    List<Role> getRoles();
}
