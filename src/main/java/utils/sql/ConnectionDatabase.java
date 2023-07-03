package utils.sql;

import utils.InfoLogger;

import java.sql.*;
import java.util.Objects;
import static constants.sql.DatabaseConstants.*;
public class ConnectionDatabase {
    private static Connection connection = null;
    public static Connection getConnection() {
        if (Objects.isNull(connection)) {
            try {
                InfoLogger.info("Connecting to DataBase....");
                Class.forName(DRIVER_DB);
                connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                InfoLogger.info("Connection is successful!");
            } catch (ClassNotFoundException | SQLException e) {
                InfoLogger.error(e.getMessage());
                InfoLogger.info("Connection is not successfully!");
            }
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            connection = null;
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
        }
    }
    public static PreparedStatement prepareStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        }catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                InfoLogger.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}