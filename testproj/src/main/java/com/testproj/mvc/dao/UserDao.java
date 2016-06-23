package com.testproj.mvc.dao;

import com.testproj.mvc.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Николай on 23.06.2016.
 */
@Repository
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        setType("User");
    }
}
