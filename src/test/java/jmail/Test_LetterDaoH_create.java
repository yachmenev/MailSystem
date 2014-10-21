package jmail;

import jmail.dao.LetterDao;
import jmail.dao.LetterDaoImpHibernate;
import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.model.Letter;
import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Admin on 18.10.14.
 */
public class Test_LetterDaoH_create {
    private static UserDao userDao = new UserDaoImpHibernate();
    private static LetterDao letterDao = new LetterDaoImpHibernate();

    private static User user1 = null;
    private static User user2 = null;
    private static String title = null;
    private static String body = null;
    private static Date date = null;
    private static Letter letter = null;

    @BeforeClass
    public static void init() {
        List<User> list = userDao.all();
        Random random = new Random();
        int u1 = random.nextInt(list.size());
        int u2 = 0;
        do {
            u2 = random.nextInt(list.size());
        } while (u2 == u1);
        user1 = userDao.find(list.get(u1).getLogin());
        user2 = userDao.find(list.get(u2).getLogin());
        title = UUID.randomUUID().toString();
        body = UUID.randomUUID().toString();
        date = new Date();
        letter = new Letter(title, user1, user2, date, body);
    }
    @Test
    public void _letterCreate(){
       letterDao.create(letter);

       //Assert.assertNotNull(userDao.find(user.getLogin()));
    }
}
