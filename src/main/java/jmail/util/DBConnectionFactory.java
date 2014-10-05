package jmail.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Admin on 05.10.14.
 */
public class DBConnectionFactory {

    private static String HOST;
    private static String PORT;
    private static String USER;
    private static String PASS;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/db.properties"));
            HOST = properties.getProperty("db.host");
            PORT = properties.getProperty("db.port");
            USER = properties.getProperty("db.user");
            PASS = properties.getProperty("db.pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, "jmail"), USER, PASS);
    }
}
