package jmail.exceptions;

/**
 * Created by Admin on 15.10.14.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String s) {
        System.out.println("Could not found user" + s);
    }
}
