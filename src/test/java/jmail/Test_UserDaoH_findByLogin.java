package jmail;

import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.exceptions.UserNotFoundException;
import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 14.10.14.
 */
public class Test_UserDaoH_findByLogin {
    private static UserDao userDao = new UserDaoImpHibernate();
    private static User user = null;
    private static User expect_user = null;

    @BeforeClass
    public static void init() {
        List<User> list = userDao.all();
        Random random = new Random();
        int i = random.nextInt(list.size());
        expect_user = list.get(i);
    }
    @Test
    public void _findByLogin(){
        user = userDao.find(expect_user.getLogin());
        System.out.println("Expected user: " + expect_user);
        System.out.println("Found user: " + user);

        Assert.assertSame(expect_user, user);
    }
}
