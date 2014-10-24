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
public class Test_UserDaoH_delete {

    @Autowired
    private static UserDao userDao;

    private static User user = null;
    private static int i = 0;

    @BeforeClass
    public static void init() {
        List<User> list = userDao.all();
        Random random = new Random();
        i = random.nextInt(list.size());
        user = new User(
                list.get(i).getId(),
                list.get(i).getLogin(),
                list.get(i).getPass()
        );
    }
    @Test
    public void _delete(){
        boolean b = userDao.delete(user.getLogin());

        Assert.assertTrue(b);
    }
}