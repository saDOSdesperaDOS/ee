package controllers.jdbc;

import java.sql.*;

public final class ConnectionToDB {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/notesdb?useSSL=false";
    private static final String usr = "root";
    private static final String pass = "QwerTyui9988";
    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static ConnectionToDB instance;

    //DBCP




    //Constructor of the database connection
    private ConnectionToDB() throws SQLException {
        connection = DriverManager.getConnection(url, usr, pass);
    }
    public Connection getConnection() {
        return connection;
    }
    public static synchronized ConnectionToDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionToDB();
        } else if (instance.getConnection().isClosed()) instance = new ConnectionToDB();
            return instance;
    }

    public static void rollBackQuietly(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                //NOP
            }
        }
    }
    public static void closeQuietly(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                //NOP
            }
        }
    }
    public static void closeQuietly(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                //NOP
            }
        }
    }
    public static void closeQuietly(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                //NOP
            }
        }
    }
    public static void closeQuietly() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                //NOP
            }
        }
    }
}
