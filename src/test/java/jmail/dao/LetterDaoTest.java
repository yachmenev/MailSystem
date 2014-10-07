package jmail.dao;

import jmail.dao.LetterDao;
import jmail.dao.LetterDaoImp;
import jmail.dao.UserDao;
import jmail.dao.UserDaoImp;
import jmail.model.Letter;
import jmail.model.User;
import jmail.service.UserService;
import jmail.service.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class LetterDaoTest {
    private UserDao userDao = new UserDaoImp();
    private LetterDao letterDao = new LetterDaoImp();

    private User user1 = null;
    private User user2 = null;

    // todo think about id of user
    @Before
    public void addUsers(){
        user1 = new User(1, "ricky8", "1234");
        user2 = new User(2, "vova22", "1234");
        userDao.create(user1);
        userDao.create(user2);
    }

    @Test
    public void testCreateLetter(){
        letterDao.create(
                new Letter("testTitle", user1, user2, new Date(), "some text"));
    }
/*
    @After
    public void delUser(){
        userDao.delete(user1.getLogin());
        userDao.delete(user2.getLogin());
    }
    @After
    public void delLetter(){
        letterDao.delete(1);
    }
    */
}