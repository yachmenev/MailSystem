package jmail.dao;

import jmail.exceptions.UserNotFoundException;
import jmail.model.User;

import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public interface UserDao {

    public User findById(int id);

    public User find(String login);

    public void create(User user);

    public boolean update(int id, User user);

    public boolean delete(String login);

    public List<User> all();
}
