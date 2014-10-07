package jmail.dao;

import jmail.model.Letter;
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
        return null;
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

    }

    @Override
    public void delete(int id) {

    }
}