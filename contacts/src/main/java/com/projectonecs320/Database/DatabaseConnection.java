package com.projectonecs320.Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection connectToDatabase(String databaseName) {
        Connection conn = null;
        String url = "jdbc:sqlite:C:/sqlite/" + databaseName;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                return conn;
            }
        }
        return conn;
    }

    // https://www.javatpoint.com/java-sqlite

    public static void createNewTable(Connection conn, String sqlStatement) {
        try {
            Statement statement = conn.createStatement();
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertRecords(Connection conn, String sqlStatement) {
        try {
            Statement statement = conn.prepareStatement(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
