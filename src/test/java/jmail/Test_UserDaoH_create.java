package jmail;

import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.exceptions.UserNotFoundException;
import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.management.Query;
import java.util.List;
import java.util.UUID;

/**
 * Created by Admin on 14.10.14.
 */
public class Test_UserDaoH_create {
    private static UserDao userDao = new UserDaoImpHibernate();
    private static User user = null;
    private static User find_user = null;


    @BeforeClass
    public static void init() {
        String loginUser1 = UUID.randomUUID().toString(); // for generate random value
        String pass = UUID.randomUUID().toString(); // for generate random pass
        user = new User(loginUser1, pass);
    }
    @Test
    public void _createUser(){
        userDao.create(user);
        Assert.assertNotNull(userDao.find(user.getLogin()));
    }
}
