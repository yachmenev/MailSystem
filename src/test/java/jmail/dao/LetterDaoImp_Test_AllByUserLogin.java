package jmail.dao;

import jmail.model.Letter;
import org.junit.Test;

import java.util.List;

/**
 * Created by Admin on 09.10.14.
 */
public class LetterDaoImp_Test_AllByUserLogin {
    private static LetterDao letterDao = new LetterDaoImp();
    private static List<Letter> list = null;


    @Test
    public void _findById(){
        list = letterDao.allByUserLogin("User-1");
        for (Letter l : list) System.out.println(l);
    }
}
