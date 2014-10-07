package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Admin on 06.10.14.
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class GeneralIntegrationTests {
    private static UserDao userDao = new UserDaoImp();
    private static LetterDao letterDao = new LetterDaoImp();

    private static User user1 = null;
    private static User user2 = null;

    //todo think about id of user
    @BeforeClass
    public static void init() {
        String loginUser1 = UUID.randomUUID().toString(); // for generate random value
        String loginUser2 = UUID.randomUUID().toString();
        user1 = userDao.create(new User(loginUser1, "1234"));
        user2 = userDao.create(new User(loginUser2, "1234"));
        Assert.assertNotNull(userDao.find(user1.getLogin()));
        Assert.assertNotNull(userDao.find(user2.getLogin()));

    }
    @Test
    public void _2_createLetter(){
        letterDao.create(
                new Letter("testTitle1", user1, user2, new Date(), "some text u1 - u2"));
        letterDao.create(
                new Letter("testTitle2", user2, user1, new Date(), "some text u2 - u1"));
    }

    @Test
    public void _3_testAllLetters(){
        List<Letter> letterList = letterDao.allByUserLogin(user1.getLogin());
        Assert.assertEquals(2, letterList.size());
    }

}
