package jmail;

import jmail.dao.LetterDao;
import jmail.dao.UserDao;
import jmail.model.Letter;
import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context.xml"})
public class Test_LetterDaoH_create {

    @Autowired
    private LetterDao letterDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void _createLetter(){
        User user_from = userDao.findById(1);
        User user_to = userDao.findById(2);
        String title = "Letter from User1 to User2";
        String body = "Hello User2 from User1";
        Letter letter = new Letter(title, user_to, user_from, new Date(), body);
        letterDao.create(letter);
    }
}