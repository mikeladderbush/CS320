package com.projectonecs320.Database;

import java.sql.Statement;

import com.projectonecs320.Classes.User;
import com.projectonecs320.Enums.tableEnum;

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

    public Statement readRecords(Connection conn, String sqlStatement) {
        Statement statement = null;
        try {
            statement = conn.prepareStatement(sqlStatement);
            statement.executeQuery(sqlStatement);
            return statement;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statement;
    }

    public static <T> void insertRecords(Connection conn, T object, tableEnum table) {

        String sqlStatement;

        try {
            if (table == tableEnum.USER && object.getClass() == User.class) {
                User user = (User) object;
                sqlStatement = "INSERT INTO users (firstName, lastName, username, password, email, phone, address, sex, dob, permissions) "
                        + String.format("VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d', '%s')",
                                user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(),
                                user.getEmail(), user.getPhone(), user.getAddress(),
                                user.getSex(), user.getDob(), user.getPermissions());
                Statement statement = conn.prepareStatement(sqlStatement);
                statement.executeUpdate(sqlStatement);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteRecords(Connection conn, String sqlStatement) {
        try {
            Statement statement = conn.prepareStatement(sqlStatement);
            statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
