package jmail.service;

import jmail.dao.LetterDao;
import jmail.dao.UserDao;
import jmail.model.Letter;

import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private LetterDao letterDao;


    @Override
    public void sendMessage(String from, String to, String title, String body) {

    }

    @Override
    public List getUnreadLetters(String login) {
        return null;
    }

    @Override
    public List<Letter> allLettersByUserLogin() {
        return null;
    }

    @Override
    public void registerUser(String login, String pass) {

    }

    @Override
    public void signIn(String login, String pass) {

    }
}
