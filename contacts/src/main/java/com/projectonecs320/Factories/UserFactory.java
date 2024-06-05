package com.projectonecs320.Factories;

import java.util.function.Consumer;

import com.projectonecs320.Classes.Administrator;
import com.projectonecs320.Classes.Employee;
import com.projectonecs320.Classes.User;
import com.projectonecs320.Enums.Permissions;
import com.projectonecs320.Services.UserService;

public class UserFactory {

    private static final UserService userService = new UserService();

    // Method to create a User with default values
    public static User createUser() {
        String id = userService.generateId();
        Permissions permissions = Permissions.USER_ACCESS;
        return new User.UserBuilder<>(id, permissions).buildUser();
    }

    public static User createUser(Consumer<User.UserBuilder<?>> consumer) {
        String id = userService.generateId();
        Permissions permissions = Permissions.USER_ACCESS;
        User.UserBuilder<?> builder = new User.UserBuilder<>(id, permissions);
        consumer.accept(builder);
        return builder.buildUser();
    }

    public static Employee createEmployee() {
        String id = userService.generateId();
        Permissions permissions = Permissions.FULL_CONTROL;
        return new Employee.EmployeeBuilder(id, permissions).buildUser();
    }

    public static Employee createEmployee(Consumer<Employee.EmployeeBuilder> consumer) {
        String id = userService.generateId();
        Permissions permissions = Permissions.EMPLOYEE_ACCESS;
        Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder(id, permissions);
        consumer.accept(builder);
        return builder.buildUser();
    }

    public static User createAdministrator() {
        String id = userService.generateId();
        Permissions permissions = Permissions.FULL_CONTROL;
        return new Administrator.AdministratorBuilder(id, permissions).buildUser();
    }

    public static Administrator createAdministrator(Consumer<Administrator.AdministratorBuilder> consumer) {
        String id = userService.generateId();
        Permissions permissions = Permissions.FULL_CONTROL;
        Administrator.AdministratorBuilder builder = new Administrator.AdministratorBuilder(id, permissions);
        consumer.accept(builder);
        return builder.buildUser();
    }
}
