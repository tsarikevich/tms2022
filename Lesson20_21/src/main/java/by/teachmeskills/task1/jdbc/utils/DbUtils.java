package by.teachmeskills.task1.jdbc.utils;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbUtils {
    private final String URL = "jdbc:mysql://localhost:3306/SHOP_DB";
    private final String USER_NAME = "root";
    private final String PASSWORD = "1234";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
