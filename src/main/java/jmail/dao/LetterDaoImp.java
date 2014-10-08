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
            //todo write valid query for select
            String query = null;
            query = String.format("SELECT * FROM letters WHERE " +
                    "to_user=(SELECT user_id FROM users WHERE login='%s') " +
                    "OR from_user=(SELECT user_id FROM users WHERE login='%s')", login, login);
            ResultSet resultSet = statement.executeQuery(query);
            List<Letter> letters = new ArrayList<Letter>();
            while (resultSet.next()){
                Letter letter = new Letter(
                        resultSet.getInt("letter_id"),
                        resultSet.getString("title"),
                        null,
                        null,
                        resultSet.getDate("send_date"),
                        resultSet.getString("body"));
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
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format(
                    "SELECT * FROM letters WHERE letter_id='%d'", id));
            letter = convert(rs);
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
                        new User(rs.getInt("to_user")),
                        new User(rs.getInt("from_user")),
                        rs.getDate("send_date"),
                        rs.getString("body"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return letter;
    }

}