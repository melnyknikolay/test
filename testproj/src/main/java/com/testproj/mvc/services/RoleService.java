package com.testproj.mvc.services;

import com.testproj.mvc.dao.AbstractDao;
import com.testproj.mvc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Николай on 23.06.2016.
 */
@Service
public class RoleService extends AbstractService<Role> {

    @Autowired
    @Override
    public void setDao(AbstractDao<Role> dao) {
        super.setDao(dao);
    }
}
