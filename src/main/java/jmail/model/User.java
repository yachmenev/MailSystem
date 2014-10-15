package jmail.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 04.10.14.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "login", unique = true, nullable = false)
    private String login;

    @Column (name = "pass", nullable = false)
    private String pass;

    @OneToMany (targetEntity = Letter.class, fetch = FetchType.LAZY)
    private List<Letter> sent = new ArrayList<Letter>();

    @OneToMany (targetEntity = Letter.class, fetch = FetchType.LAZY)
    private List<Letter> received = new ArrayList<Letter>();

    @OneToMany (targetEntity = User.class, fetch = FetchType.LAZY)
    private List<User> contacts;

    public User() {
    }

    public User(int id, String login) {
        this.id = id;
        this.login = login;
        this.pass = "";
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPass() {
        return pass;
    }

    public List<Letter> getSent() {
        return sent;
    }

    public void setSent(List<Letter> sent) {
        this.sent = sent;
    }

    public List<Letter> getReceived() {
        return received;
    }

    public void setReceived(List<Letter> received) {
        this.received = received;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<User> getContacts() {
        return contacts;
    }

    public void setContacts(List<User> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}