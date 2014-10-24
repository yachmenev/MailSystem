package jmail;

import jmail.dao.LetterDao;
import jmail.dao.UserDao;
import jmail.model.Letter;
import jmail.model.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context.xml"})
public class Test_LetterDaoH_findByUser {
    static List<Letter> list = null;
    static Letter letter;

    @Autowired
    private static LetterDao letterDao;
    @Autowired
    private static UserDao userDao;

    @Test
    public void _findById(){
        letter = letterDao.findById(1);
        System.out.println(letter);
    }
}