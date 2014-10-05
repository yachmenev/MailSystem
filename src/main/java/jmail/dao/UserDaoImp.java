package jmail.dao;

import jmail.model.User;

import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public class UserDaoImp implements UserDao {
    @Override
    public User find(String login) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String login) {
        return false;
    }

    @Override
    public List<User> all() {
        return null;
    }
}
