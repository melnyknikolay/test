package com.testproj.mvc.dao;

import com.testproj.mvc.model.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by Николай on 23.06.2016.
 */
@Repository
public class RoleDao extends AbstractDao<Role> {

    public RoleDao() {
        setType("Role");
    }
}
