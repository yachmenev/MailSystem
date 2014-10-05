package jmail.dao;

import jmail.model.Letter;
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
public class LetterDaoImp implements LetterDao{
    @Override
    public void create(Letter letter) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            String query = String.format(
                    "INSERT INTO letters (title, body, to_user, from_user, send_date) VALUES " +
                            "('%s', '%s', '%s', '%s', '%s')", letter.getTitle(), letter.getBody(), letter.getTo().getId(),
                    letter.getFrom().getId(), new java.sql.Date(System.currentTimeMillis()).toString());
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
                Letter letter = new Letter(resultSet.getInt("letter_id"), resultSet.getString("title"),
                        resultSet.getString("body"), null, null, resultSet.getDate("send_date"));
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
}
