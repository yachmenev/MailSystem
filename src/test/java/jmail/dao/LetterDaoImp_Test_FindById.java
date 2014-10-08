package jmail.dao;

import jmail.model.Letter;
import org.junit.Test;

/**
 * Created by Admin on 08.10.14.
 */
public class LetterDaoImp_Test_FindById {
    private static LetterDao letterDao = new LetterDaoImp();
    private static Letter letter = null;


    @Test
    public void _findById(){
        letter = letterDao.findById(1);
        System.out.println(letter);
    }
}
