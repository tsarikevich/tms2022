package by.teachmeskills.task1.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static String dbUrl = "jdbc:mysql://localhost:3306/SHOP_DB";
    private static String dbUsername = "root";
    private static String dbPassword = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
