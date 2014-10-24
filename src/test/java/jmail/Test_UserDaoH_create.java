package jmail;

import jmail.dao.UserDao;
import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context.xml"})
public class Test_UserDaoH_create {

    @Autowired
    private UserDao userDao;

    private static User user = null;

    @BeforeClass
    public static void init() {
        String loginUser1 = UUID.randomUUID().toString(); // for generate random value
        user = new User(loginUser1, "0000");
    }
    @Test
    public void _createUser(){
        userDao.create(user);
        Assert.assertNotNull(userDao.find(user.getLogin()));
    }
}