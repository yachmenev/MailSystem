package jmail.dao;

import jmail.model.Letter;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public interface LetterDao {

    public Letter findById(int id);

    public Letter findByDateRange(Date start, Date end);

    /*
    * Find all letters that consist keyWord in title or in body
    * */
    public List<Letter> findByKeyWord(String keyWord);


    public void create(Letter letter);

    public void update (Letter letter);

    public void delete (int id);


    public List<Letter> allByUserLogin(String login);

}
