package jmail.dao.tmp;

import jmail.dao.UserDao;
import jmail.dao.UserDaoImpHibernate;
import jmail.exceptions.UserNotFoundException;

/**
 * Created by Admin on 15.10.14.
 */
public class Test_UserDaoH_delete {
    public static void main(String[] args) throws UserNotFoundException {
        UserDao userDao = new UserDaoImpHibernate();
        userDao.delete("Philip");
    }
}
