package jmail.dao;

import jmail.model.User;

import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public interface UserDao {

    public User find(String login);

    public void create(User user);

    public boolean update(User user);

    public boolean delete(String login);

    public List<User> all();
}
