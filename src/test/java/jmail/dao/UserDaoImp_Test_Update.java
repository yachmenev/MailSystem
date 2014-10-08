package jmail.dao;

import jmail.model.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

/**
 * Created by Admin on 08.10.14.
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class UserDaoImp_Test_Update {
    private static UserDao userDao = new UserDaoImp();
    private static User user = new User(1, "Test user", "0000");

    @Test
    public void _updateUser(){
        userDao.update(user);
    }
}
