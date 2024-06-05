package com.projectonecs320.Factories;

import java.util.function.Consumer;

import com.projectonecs320.Classes.User;
import com.projectonecs320.Services.UserService;

public class UserFactory {

    private static final UserService userService = new UserService();

    // Method to create a User with default values
    public static User createUser() {
        String id = userService.generateId();
        return new User.UserBuilder(id).buildUser();
    }

    public static User createUser(Consumer<User.UserBuilder> consumer) {
        String id = userService.generateId();
        User.UserBuilder builder = new User.UserBuilder(id);
        consumer.accept(builder);
        return builder.buildUser();
    }
}
