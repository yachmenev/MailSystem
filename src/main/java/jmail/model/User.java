package jmail.model;

import java.util.List;

/**
 * Created by Admin on 04.10.14.
 */
public class User {
    private int id;
    private String login;
    private String pass;
    private List<Letter> letters;
    private List<User> contacts;

    public User() {
    }

    public User(int id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return login;
    }

    public void setName(String name) {
        this.login = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

    public List<User> getContacts() {
        return contacts;
    }

    public void setContacts(List<User> contacts) {
        this.contacts = contacts;
    }
}
