package com.projectonecs320.Factories;

import java.util.function.Consumer;

import com.projectonecs320.Classes.Task;
import com.projectonecs320.Services.TaskService;

public class TaskFactory {

    private static final TaskService taskService = new TaskService();

    // Method to create a Task with default values
    public static Task createTask() {
        String id = taskService.generateId();
        return new Task.TaskBuilder(id).buildTask();
    }

    public static Task createTask(Consumer<Task.TaskBuilder> consumer) {
        String id = taskService.generateId();
        Task.TaskBuilder builder = new Task.TaskBuilder(id);
        consumer.accept(builder);
        return builder.buildTask();
    }
}
