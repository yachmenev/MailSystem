package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import jmail.util.DBConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LetterDaoImp implements LetterDao{
    User to_user = null, from_user = null, user = null;

    @Override
    public void create(Letter letter) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            String query = String.format(
                    "INSERT INTO letters (title, to_user, from_user, send_date, body) VALUES " +
                            "('%s', '%s', '%s', '%s', '%s')",
                    letter.getTitle(),
                    letter.getTo().getId(),
                    letter.getFrom().getId(),
                    new java.sql.Date(System.currentTimeMillis()).toString(),
                    letter.getBody());
            statement.execute(query);
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
    public List<Letter> allByUserLogin(String login) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            List<Letter> letters = new ArrayList<Letter>();
            //todo write valid query for select
            ResultSet resultSet_user = statement.executeQuery(String.format(
                    "select users.user_id, users.login from users " +
                            "where login='%s'", login));
            try {
                while (resultSet_user.next()){
                    user = new User(resultSet_user.getInt("user_id"), resultSet_user.getString("login"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResultSet resultSet_to = statement.executeQuery(String.format(
                    "SELECT *, users.user_id, users.login " +
                    "FROM letters, users " +
                    "WHERE to_user=(SELECT user_id FROM users WHERE login='%s') " +
                    "AND user_id=from_user", login));

            while (resultSet_to.next()){
                Letter letter = new Letter(
                        resultSet_to.getInt("letter_id"),
                        resultSet_to.getString("title"),
                        user,
                        new User(resultSet_to.getInt("user_id"), resultSet_to.getString("login")),
                        resultSet_to.getDate("send_date"),
                        resultSet_to.getString("body"));
                letters.add(letter);
            }

            ResultSet resultSet_from = statement.executeQuery(String.format(
                    "SELECT *, users.user_id, users.login " +
                            "FROM letters, users " +
                            "WHERE from_user=(SELECT user_id FROM users WHERE login='%s') " +
                            "AND user_id=to_user", login));

            while (resultSet_from.next()){
                Letter letter = new Letter(
                        resultSet_from.getInt("letter_id"),
                        resultSet_from.getString("title"),
                        new User(resultSet_from.getInt("user_id"), resultSet_from.getString("login")),
                        user,
                        resultSet_from.getDate("send_date"),
                        resultSet_from.getString("body"));
                letters.add(letter);
            }

            return letters;
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
        return null;
    }

    @Override
    public Letter findById(int id) {
        Connection connection = null;
        Statement statement = null;
        Letter letter = null;
        UserDaoImp userDaoImp = new UserDaoImp();
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();

            ResultSet rs2 = statement.executeQuery(String.format(
                    "select users.user_id, users.login from letters, users " +
                            "where letter_id='%d' and user_id=from_user", id));
            try {
                while (rs2.next()){
                    from_user = new User(rs2.getInt("user_id"), rs2.getString("login"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResultSet rs = statement.executeQuery(String.format(
                    "select letters.*, users.user_id, users.login from letters, users " +
                            "where letter_id='%d' and user_id=to_user", id));
            letter = convert(rs);

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
        return letter;
    }

    @Override
    public Letter findByDateRange(Date start, Date end) {
        return null;
    }

    @Override
    public List<Letter> findByKeyWord(String keyWord) {
        return null;
    }

    @Override
    public void update(Letter letter) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            connection.setAutoCommit(false); // begin transaction
            statement.execute(String.format(
                    "UPDATE letters SET title='%s', body='%s' WHERE letter_id='%d'",
                    letter.getTitle(), letter.getBody(), letter.getId()));
            connection.commit(); // end transaction
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
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            connection.setAutoCommit(false); // begin transaction
            statement.execute(String.format("DELETE FROM letters WHERE letter_id='%d'", id));
            connection.commit(); // end transaction
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

    }

    private Letter convert(ResultSet rs){
        Letter letter = null;
        try {
            while (rs.next()){
                letter = new Letter(
                        rs.getInt("letter_id"),
                        rs.getString("title"),
                        new User(rs.getInt("user_id"), rs.getString("login")),
                        from_user,
                        rs.getDate("send_date"),
                        rs.getString("body"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return letter;
    }

}