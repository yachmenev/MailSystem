package jmail.dao;

import jmail.model.Letter;

import java.util.List;

/**
 * Created by Admin on 15.10.14.
 */
public class Test_LetterDaoH_allByUserLogin {
    public static void main(String[] args) {
        LetterDao letterDao = new LetterDaoImpHibernate();
        List<Letter> list = letterDao.allByUserLogin("Jack0");
        for (Letter l : list)
            System.out.println(l);
    }
}
