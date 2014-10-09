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
    private static User user1 = new User(1, "User-1", "0000");
    private static User user2 = new User(2, "User-2", "0000");

    @Test
    public void _updateUser(){
        userDao.update(user1);
        userDao.update(user2);
    }
}
