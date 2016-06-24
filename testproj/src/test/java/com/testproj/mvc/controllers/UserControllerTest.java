package com.testproj.mvc.controllers;

import com.testproj.mvc.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Николай on 24.06.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController = new UserController();

    @Test
    public void testGet() throws Exception {

    }


}