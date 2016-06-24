package com.testproj.mvc.services;

import com.testproj.mvc.dao.AbstractDao;
import com.testproj.mvc.model.Role;
import com.testproj.mvc.model.User;
import org.hamcrest.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Николай on 24.06.2016.
 */
@ContextConfiguration({"classpath:spring/spring-app.xml",
                       "classpath:spring/spring-db.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void testSave() throws Exception {
        User testUser = new User("NEW", "PASS", true, new Role(1, "ROLE_ADMIN"));
        User created = service.save(testUser);
        assertEquals(testUser.getName(), created.getName());
        assertEquals(testUser.getActive(), created.getActive());
        assertEquals(testUser.getRole().getName(), created.getRole().getName());
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {
        User testUser = new User(1, "NEW", "PASS", true, new Role(3, "ROLE_ADMIN"));
        User created = service.save(testUser);
        assertNotNull(created);
        assertEquals(testUser.getId(), created.getId());
        assertEquals(testUser.getName(), created.getName());
        assertEquals(testUser.getActive(), created.getActive());
        assertEquals(testUser.getRole().getName(), created.getRole().getName());
    }

    @Test(expected = NotFoundException.class)
    public void testGetByIdNotFound() throws Exception {
        service.getById(0);
    }

    @Test
    public void testGetByName() throws Exception {
        User testUser = new User("NEWName", "PASS", true, new Role(3, "ROLE_ADMIN"));
        service.save(testUser);
        User fromBase = service.getByName("NEWName");
        assertNotNull(fromBase);
        assertEquals(testUser.getName(), fromBase.getName());
        assertEquals(testUser.getActive(), fromBase.getActive());
        assertEquals(testUser.getRole(), fromBase.getRole());
    }

    @Test
    public void testGetEntyties() throws Exception {
        List<User> before = service.getEntyties();
        service.delete(1);
        List<User> after = service.getEntyties();
        before.remove(1);
        assertEquals(before, after);
    }
}