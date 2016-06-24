package com.testproj.mvc.dao;

import com.testproj.mvc.model.Role;
import com.testproj.mvc.model.User;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.acls.model.NotFoundException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Николай on 24.06.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @Mock
    Session session;

    @InjectMocks
    UserDao userDao = new UserDao();

    @Test
    public void testSave() throws Exception {

        User user = new User("Name", "Pass", true, new Role(1, "ROLE_ADMIN"));
        User save = userDao.save(user);
        Assert.assertEquals(user, save);
//        assertEquals(user.getName(), save.getName());
//        assertEquals(user.getActive(), save.getActive());
//        assertEquals(user.getRole().getName(), save.getRole().getName());
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test(expected = NotFoundException.class)
    public void testGetById() throws Exception {
        userDao.getById(0);
    }

    @Test
    public void testGetByName() throws Exception {
        User testUser = new User("NEWName", "PASS", true, new Role(3, "ROLE_ADMIN"));
        userDao.save(testUser);
        User fromBase = userDao.getByName("NEWName");
        assertNotNull(fromBase);
        assertEquals(testUser.getName(), fromBase.getName());
        assertEquals(testUser.getActive(), fromBase.getActive());
        assertEquals(testUser.getRole(), fromBase.getRole());
    }

    @Test
    public void testGetEntyties() throws Exception {
        List<User> before = userDao.getEntyties();
        userDao.delete(1);
        List<User> after = userDao.getEntyties();
        before.remove(1);
        assertEquals(before, after);
    }
}