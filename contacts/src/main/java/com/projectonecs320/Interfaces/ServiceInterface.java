package com.projectonecs320.Interfaces;

import java.util.Random;

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

}
