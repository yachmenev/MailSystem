package jmail.dao;

import jmail.model.User;

/**
 * Created by Admin on 21.10.14.
 */
public class Test_UserDaoHib_create {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpHibernate();
        userDao.create(new User("Login", "pass"));
    }
}
