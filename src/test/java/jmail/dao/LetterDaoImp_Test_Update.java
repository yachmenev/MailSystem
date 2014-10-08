package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import org.junit.Test;

/**
 * Created by Admin on 08.10.14.
 */
public class LetterDaoImp_Test_Update {
    private static LetterDao letterDao = new LetterDaoImp();
    private static Letter letter = new Letter(1, "Test Title", null, null, null, "Test Body");

    @Test
    public void _updateLetter(){
        letterDao.update(letter);
    }
}
