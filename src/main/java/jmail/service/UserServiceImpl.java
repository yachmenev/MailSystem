package jmail.service;

import jmail.dao.LetterDao;
import jmail.dao.UserDao;

/**
 * Created by Admin on 05.10.14.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private LetterDao letterDao;


    @Override
    public void sendMessage(String to, String title, String body) {

    }
}
