package com.projectonecs320.Interfaces;

import java.util.Random;

import com.projectonecs320.Classes.User;

public interface ServiceInterface {

    /**
     * Generates a random ID for objects.
     * 
     * @return A randomly generated ID for.
     */
    public default String generateId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int j = random.nextInt(chars.length());
            char randomChar = chars.charAt(j);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

    public default void displayInformation(User user) {
        System.out.println("User ID: " + user.getId());
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Phone: " + user.getPhone());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Sex: " + user.getSex());
        System.out.println("DOB: " + user.getDob());
        System.out.println("Permissions: " + user.getPermissions());
    }

}
