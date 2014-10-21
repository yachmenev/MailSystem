package jmail;

import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 15.10.14.
 */
public class Test_UserDaoH_findById {


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
    public void _findById(){
        user = userDao.findById(expect_user.getId());

        Assert.assertSame(expect_user, user);
    }
}