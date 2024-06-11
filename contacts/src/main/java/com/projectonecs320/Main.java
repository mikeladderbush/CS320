package com.projectonecs320;

import java.sql.Connection;

import com.projectonecs320.Classes.User;
import com.projectonecs320.Database.DatabaseConnection;
import com.projectonecs320.Database.DatabaseStatement;
import com.projectonecs320.Factories.UserFactory;
import com.projectonecs320.Services.UserService;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection conn = dbConnection.connectToDatabase("test.db");

        DatabaseStatement dbStatement = new DatabaseStatement();
        dbStatement.defineTables(conn);

        UserService userService = new UserService();

        User testUser = UserFactory.createUser(builder -> {
            builder
                    .firstName("Mike")
                    .lastName("Ladderbush")
                    .username("Mikel123")
                    .password("Applesauce1%")
                    .email("mikeladderbush@gmail.com")
                    .phone("9787708430")
                    .address("160 Cottage Street")
                    .sex("Male")
                    .dob("2/24/97")
                    .paymentOptions(null);
        });

        userService.addUser(testUser);
        userService.displayInformation(testUser);
        DatabaseStatement.insertRecords(conn, testUser);
    }
}
