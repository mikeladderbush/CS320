package com.projectonecs320.Classes;

import com.projectonecs320.Interfaces.UserUtils;

/**
 * Represents a User.
 */
public class User implements UserUtils {

    private String id;
    private String username;
    private String password;
    private String email;
    private Permissions permissions;

    public static class UserBuilder {

        private String id;
        private String username = "NO FIRST NAME ON FILE";
        private String password = "NO LAST NAME ON FILE";
        private String email = "NO PHONE NUMBER ON FILE";
        private Permissions permissions;

        public UserBuilder(String id) {
            this.id = id;
        }

        public UserBuilder username(String value) {
            this.username = value;
            return this;
        }

        public UserBuilder password(String value) {
            this.password = value;
            return this;
        }

        public UserBuilder email(String value) {
            this.email = value;
            return this;
        }

        public UserBuilder permissions(Permissions permissions) {
            this.permissions = permissions;
            return this;
        }

        public User buildUser() {
            return new User(this);
        }
    }

    private User(UserBuilder UserBuilder) {
        id = UserBuilder.id;
        username = UserBuilder.username;
        password = UserBuilder.password;
        email = UserBuilder.email;
        permissions = UserBuilder.permissions;
    }

    /**
     * Retrieves the ID of the User.
     * 
     * @return The ID of the User.
     */
    public String getId() {
        return id;
    }

    /**
     * For testing purpose only.
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the username of the User.
     * 
     * @return The username of the User.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the User.
     * 
     * @param username The username of the User.
     * @throws IllegalArgumentException if the username is null or exceeds 10
     *                                  characters.
     */
    public void setUsername(String username) {
        if (username != null && username.length() <= 10) {
            this.username = username;
        } else {
            throw new IllegalArgumentException("Username must be fewer than 10 characters");
        }
    }

    /**
     * Retrieves the password of the User.
     * 
     * @return The password of the User.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the User.
     * 
     * @param Password The password of the User.
     * @throws IllegalArgumentException if the password is null or exceeds 10
     *                                  characters.
     */
    public void setPassword(String password) {
        if (password != null && password.length() <= 10) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be fewer than 10 characters");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
            // ADD EMAIL ERROR CHECKING
        } else {
            throw new IllegalArgumentException("Email error");
        }
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        if (permissions != null) {
            this.permissions = permissions;
        } else {
            throw new IllegalArgumentException("Permission error");
        }
    }
}
