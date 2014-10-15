package jmail.dao.tmp;

import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.exceptions.UserNotFoundException;
import jmail.model.User;

/**
 * Created by Admin on 15.10.14.
 */
public class Test_UserDaoH_findById {
public static void main(String[]args) throws UserNotFoundException {
    UserDao userDao = new UserDaoImpHibernate();
    User user = null;

    user = userDao.findById(14);
    System.out.println(user);
    }
}
