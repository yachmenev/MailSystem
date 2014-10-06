package jmail.service;

import jmail.model.Letter;

import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public interface UserService {

    public void sendMessage(String from, String to, String title, String body);

    public List getUnreadLetters(String login);

    public List<Letter> allLettersByUserLogin();

    public void registerUser(String login, String pass);

    public void signIn(String login, String pass);

}
