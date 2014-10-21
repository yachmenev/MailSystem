/*
package jmail.dao;

import jmail.model.Letter;


import java.util.List;
import java.util.Random;


public class Test_LetterDaoH_allByUserLogin {
        LetterDao letterDao = new LetterDaoImpHibernate();
        UserDao userDao = new UserDaoImpHibernate();
        List<Letter> list = letterDao.allByUserLogin("Jack0");

 @BeforeClass
    public static void init() {
        List<User> list = userDao.all();
        Random random = new Random();
        int i = random.nextInt(list.size());
        expect_user = list.get(i);
    }
    @BeforeClass
    public static void init() {
        List<Letter> list = letterDao.all();
        Random random = new Random();
        int i = random.nextInt(list.size());
        expect_letter = list.get(i);
    }
    @Test
    public void _findById(){
        letter = letterDao.findById(expect_user.getId());

        Assert.assertSame(expect_user, user);
    }

}
*/
