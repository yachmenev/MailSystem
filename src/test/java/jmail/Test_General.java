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
public class Test_General {

    @Autowired
    private UserDao userDao;

    private User user = null;
    private User user_find_ID = null;
    private User user_find_Login = null;

    @Test
    public void _createUser(){
        String loginUser1 = UUID.randomUUID().toString(); // for generate random value
        user = new User(loginUser1, "0000");
        userDao.create(user);
        System.out.println("Create: passed");
        user_find_ID = userDao.findById(user.getId());
        System.out.println("Find by Id: passed");

        Assert.assertNotNull(userDao.find(user.getLogin()));
        System.out.println("Find by Login: passed");
        Assert.assertNotNull(userDao.findById(user.getId()));
        Assert.assertEquals(user.getLogin(), user_find_ID.getLogin());
    }
}