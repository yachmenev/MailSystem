package jmail.dao;

import jmail.model.User;
import jmail.util.DBConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            statement.execute(String.format("INSERT INTO users(login, pass) VALUES ('%s', '%s')", user.getLogin(), user.getPass()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

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
