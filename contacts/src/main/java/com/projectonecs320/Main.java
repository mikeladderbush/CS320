package com.projectonecs320;

import java.sql.Connection;

import com.projectonecs320.Database.DatabaseConnection;
import com.projectonecs320.Database.DatabaseStatement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection conn = dbConnection.connectToDatabase("test.db");

        DatabaseStatement dbStatement = new DatabaseStatement();
        dbStatement.defineTables(conn);
    }
}
