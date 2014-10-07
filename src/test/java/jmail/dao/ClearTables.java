package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Admin on 07.10.14.
 */
public class ClearTables {
    private UserDao userDao = new UserDaoImp();
    private LetterDao letterDao = new LetterDaoImp();

    private User user1 = new User(1, "ricky8", "1234");
    private User user2 = new User(2, "vova22", "1234");


    @Test
    public void delLetter(){
        letterDao.delete(user1.getId());
        letterDao.delete(user2.getId());
    }
    @Test
    public void delUser(){
        userDao.delete(user1.getLogin());
        userDao.delete(user2.getLogin());
    }
}
