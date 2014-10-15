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
 * Created by Admin on 15.10.14.
 */
public class Test_UserDaoH_delete {
    private static UserDao userDao = new UserDaoImpHibernate();
    private static User user = null;
    private static User before_user = null;
    private static int i = 0;

    @BeforeClass
    public static void init() {
        List<User> list = userDao.all();
        Random random = new Random();
        i = random.nextInt(list.size());
        before_user = new User(list.get(i).getId(), list.get(i).getLogin(), list.get(i).getPass());

    }
    @Test
    public void _findByLogin(){
        boolean b = userDao.delete(before_user.getLogin());

        Assert.assertTrue(b);
    }
}
