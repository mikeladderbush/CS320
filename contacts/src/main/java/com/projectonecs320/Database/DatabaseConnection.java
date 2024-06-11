package com.projectonecs320.Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection connectToDatabase(String databaseName) {
        Connection conn = null;
        String url = "jdbc:sqlite:C:/Program Files (x86)/sqlite/" + databaseName;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("PRAGMA foreign_keys = ON");
                    DatabaseStatement databaseStatement = new DatabaseStatement();
                    databaseStatement.defineTables(conn);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                return conn;
            }
        }
        return conn;
    }
}
