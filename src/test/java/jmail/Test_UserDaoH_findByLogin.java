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

import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context.xml"})
public class Test_UserDaoH_findByLogin {

    @Autowired
    private UserDao userDao;

    private static User user = null;
    private static User expect_user = null;

    @Test
    public void _findByLogin(){
        List<User> list = userDao.all();
        Random random = new Random();
        int i = random.nextInt(list.size());
        expect_user = list.get(i);
        user = userDao.find(expect_user.getLogin());
        System.out.println("Expected user: " + expect_user);
        System.out.println("Found user: " + user);

        Assert.assertSame(expect_user, user);
    }
}