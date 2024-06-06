package com.projectonecs320.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStatement {

    public void defineTables(Connection conn) {
        if (conn != null) {
            try (Statement statement = conn.createStatement()) {
                statement.execute("PRAGMA foreign_keys = ON");

                // Create Users Table
                String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS users ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "firstName TEXT NOT NULL, "
                        + "lastName TEXT NOT NULL, "
                        + "username TEXT NOT NULL, "
                        + "password TEXT NOT NULL, "
                        + "email TEXT NOT NULL, "
                        + "phone TEXT, "
                        + "address TEXT, "
                        + "sex TEXT, "
                        + "dob DATE, "
                        + "permissions TEXT"
                        + ");";
                statement.execute(sqlCreateUserTable);

                // Create Employees Table
                String sqlCreateEmployeeTable = "CREATE TABLE IF NOT EXISTS employees ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "userId INTEGER NOT NULL, "
                        + "socialSecurityNumber TEXT NOT NULL, "
                        + "position TEXT NOT NULL, "
                        + "payrate DOUBLE NOT NULL, "
                        + "paybasis TEXT NOT NULL, "
                        + "baseEarnings DOUBLE NOT NULL, "
                        + "contactInformation TEXT, "
                        + "FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE"
                        + ");";
                statement.execute(sqlCreateEmployeeTable);

                // Create Administrators Table
                String sqlCreateAdministratorTable = "CREATE TABLE IF NOT EXISTS administrators ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "employeeId INTEGER NOT NULL, "
                        + "adminLevel TEXT NOT NULL, "
                        + "FOREIGN KEY (employeeId) REFERENCES employees(id) ON DELETE CASCADE"
                        + ");";
                statement.execute(sqlCreateAdministratorTable);

                // Create Payment Options Table
                String sqlCreatePaymentOptionTable = "CREATE TABLE IF NOT EXISTS payment_options ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "name TEXT NOT NULL, "
                        + "cardNumber TEXT NOT NULL, "
                        + "expirationDate TEXT NOT NULL, "
                        + "confirmationCode TEXT NOT NULL, "
                        + "cardType TEXT NOT NULL, "
                        + "billingAddress TEXT NOT NULL, "
                        + "billingZipCode TEXT NOT NULL, "
                        + "userId INTEGER NOT NULL, "
                        + "FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE"
                        + ");";
                statement.execute(sqlCreatePaymentOptionTable);

                // Create Sessions Table
                String sqlCreateSessionTable = "CREATE TABLE IF NOT EXISTS sessions ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "sessionType TEXT NOT NULL, "
                        + "timeOfSession TEXT NOT NULL, "
                        + "dateOfSession DATE NOT NULL"
                        + ");";
                statement.execute(sqlCreateSessionTable);

                System.out.println("Tables created successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

}
