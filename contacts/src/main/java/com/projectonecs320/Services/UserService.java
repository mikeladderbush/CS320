package com.projectonecs320.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.projectonecs320.Classes.User;
import com.projectonecs320.Interfaces.ServiceInterface;

/**
 * Manages operations related to Users.
 */
public class UserService implements ServiceInterface {

    private List<User> users;

    /**
     * Constructs a UserService with an empty list of users.
     */
    public UserService() {
        this.users = new ArrayList<>();
    }

    /**
     * Adds a user to the list of users.
     * 
     * @param user The User to add.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Generates a random ID for Users.
     * 
     * @return A randomly generated ID for Users.
     */
    public String generateId() {
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

    /**
     * Updates the first name of a User with the specified ID.
     * 
     * @param id        The ID of the User.
     * @param firstName The new first name.
     */
    public void updatePassword(String id, String password) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setPassword(password);
            }
        }
    }

    /**
     * Updates the email of a User with the specified ID.
     * 
     * @param id    The ID of the User.
     * @param email The new email.
     */
    public void updateEmail(String id, String email) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setEmail(email);
            }
        }
    }

    /**
     * Deletes a User with the specified ID.
     * 
     * @param id The ID of the User to delete.
     */
    public void deleteUser(String id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    /**
     * Retrieves all Users.
     * 
     * @return A list of all Users.
     */
    public List<User> getAllUsers() {
        return users;
    }

    /**
     * Finds and retrieves a User by its ID.
     * 
     * @param id The ID of the User to find.
     * @return The User with the specified ID, or null if not found.
     */
    public User findUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
