package jmail.dao.tmp;

import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.exceptions.UserNotFoundException;
import jmail.model.User;

/**
 * Created by Admin on 14.10.14.
 */
public class Test_UserDaoH_findByLogin {
    public static void main(String[] args) throws UserNotFoundException {
        UserDao userDao = new UserDaoImpHibernate();
        User user_in = null;

        user_in = userDao.find("Reck");
        System.out.println(user_in);
    }
}
