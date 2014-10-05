package jmail.model;

import java.util.List;

/**
 * Created by Admin on 04.10.14.
 */
public class User {
    private int id;
    private String name;
    private String pass;
    private List<Letter> letters;
    private List<User> contacts;
}
