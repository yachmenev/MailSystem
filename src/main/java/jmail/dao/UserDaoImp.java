package jmail.dao;

import jmail.model.User;
import jmail.util.DBConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 05.10.14.
 */
public class UserDaoImp implements UserDao {

    @Override
    public User findById(int id) {

        Connection connection = null;
        Statement statement = null;
        User user = null;

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format(
                    "SELECT user_id, login, pass FROM users WHERE user_id='%d'", id));
            while (rs.next()){
                user = convert(rs);
            }

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

        return user;
    }

    @Override
    public User find(String login) {

        Connection connection = null;
        Statement statement = null;
        User user = null;

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format(
                    "SELECT user_id, login, pass FROM users WHERE login='%s'", login));
            user = convert(rs);
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
        return user;
    }

    @Override
    public User create(User user) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            connection.setAutoCommit(false); // begin transaction
            statement.execute(String.format("INSERT INTO users(login, pass) VALUES ('%s', '%s')",
                    user.getLogin(), user.getPass()));
            ResultSet rs = statement.executeQuery(String.format(
                    "SELECT user_id, login, pass FROM users WHERE login='%s'", user.getLogin()));
            connection.commit(); // end transaction
            return convert(rs);
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
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

        return null;
    }

    @Override
    public boolean update(User user) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            connection.setAutoCommit(false); // begin transaction
            statement.execute(String.format(
                    "UPDATE users SET login='%s', pass='%s' WHERE user_id='%d'",
                    user.getLogin(), user.getPass(), user.getId()));
            connection.commit(); // end transaction
            return true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
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
        return false;
    }

    @Override
    public boolean delete(String login) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            connection.setAutoCommit(false); // begin transaction
            statement.execute(String.format("DELETE FROM users WHERE login='%s'", login));
            connection.commit(); // end transaction
            return true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
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
        return false;
    }

    @Override
    public List<User> all() {
        Connection connection = null;
        Statement statement = null;
        User user = null;
        List<User> list = new ArrayList<User>();

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format(
                    "SELECT * FROM users"));
            while (rs.next()){
                user = new User(rs.getInt("user_id"), rs.getString("login"), rs.getString("pass"));
                list.add(user);
            }
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
        return list;
    }

    private User convert(ResultSet rs){
        User user = null;
        try {
            while (rs.next()){
                user = new User(rs.getInt("user_id"), rs.getString("login"), rs.getString("pass"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}