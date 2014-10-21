package jmail;

import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Admin on 15.10.14.
 */
public class Test_UserDaoH_all {

    private static UserDao userDao = new UserDaoImpHibernate();
    private static List<User> list = null;

    @Test
    public void _all(){
        list = userDao.all();
        for (User user : list)
            System.out.println(user);
        Assert.assertNotNull(list);
    }
}
