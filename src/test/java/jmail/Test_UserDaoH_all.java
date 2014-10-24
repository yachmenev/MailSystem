package jmail;

import jmail.dao.UserDao;
import jmail.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context.xml"})
public class Test_UserDaoH_all {

    @Autowired
    private UserDao userDao;
    private List<User> list = null;

    @Test
    public void _all(){
        list = userDao.all();
        for (User user : list)
            System.out.println(user);
        Assert.assertNotNull(list);
    }
}