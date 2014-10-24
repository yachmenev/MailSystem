package jmail;

import jmail.dao.UserDao;
import jmail.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context.xml"})
public class Test_UserDaoH_update {

    @Autowired
    private UserDao userDao;
    private User user = null;

    @Test
    public void _update(){
        user = userDao.findById(1);
        user.setPass("0000");
        userDao.update(user);
        user = userDao.findById(user.getId());
    }
}