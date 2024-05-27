package com.projectonecs320.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.projectonecs320.Classes.Task;
import com.projectonecs320.Interfaces.ServiceInterface;

/**
 * Manages operations related to tasks.
 */
public class TaskService implements ServiceInterface{

    private List<Task> tasks;

    /**
     * Constructs a TaskService with an empty list of tasks.
     */
    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list of tasks.
     * 
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Generates a random ID for tasks.
     * 
     * @return A randomly generated ID for tasks.
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
     * Updates the name of a task with the specified ID.
     * 
     * @param id The ID of the task.
     * @param name The new name of the task.
     */
    public void updateTaskName(String id, String name) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setName(name);
            }
        }
    }

    /**
     * Updates the description of a task with the specified ID.
     * 
     * @param id The ID of the task.
     * @param description The new description of the task.
     */
    public void updateTaskDescription(String id, String description) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDescription(description);
            }
        }
    }

    /**
     * Deletes a task with the specified ID.
     * 
     * @param id The ID of the task to delete.
     */
    public void deleteTask(String id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    /**
     * Retrieves all tasks.
     * 
     * @return A list of all tasks.
     */
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Finds and retrieves a task by its ID.
     * 
     * @param id The ID of the task to find.
     * @return The task with the specified ID, or null if not found.
     */
    public Task findTaskById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

}
