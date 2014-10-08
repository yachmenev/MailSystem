package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 08.10.14.
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class UserDaoImp_Test_All {
    private static UserDao userDao = new UserDaoImp();
    private static List<User> list = null;

    @Test
    public void _selectAllUsers(){
        list = userDao.all();
        for(User u : list) System.out.println(u);
    }
}
