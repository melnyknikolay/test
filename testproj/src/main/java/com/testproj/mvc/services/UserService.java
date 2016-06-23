package com.testproj.mvc.services;

import com.testproj.mvc.dao.AbstractDao;
import com.testproj.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Николай on 23.06.2016.
 */
@Service
public class UserService extends AbstractService<User> {

    @Autowired
    @Override
    public void setDao(AbstractDao<User> dao) {
        super.setDao(dao);
    }
}
