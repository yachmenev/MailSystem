package jmail.dao;

import jmail.model.Letter;

import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public interface LetterDao {

    public void create(Letter letter);

    public List<Letter> allByUserLogin(String login);

}
