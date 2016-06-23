package com.testproj.mvc.controllers;

import com.testproj.mvc.model.User;
import com.testproj.mvc.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Николай on 23.06.2016.
 */
@RestController
public class UserController extends AbstractController<User> {

    @Autowired
    @Override
    public void setService(AbstractService<User> service) {
        super.setService(service);
    }
}
