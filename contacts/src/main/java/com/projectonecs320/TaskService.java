package com.projectonecs320;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        String id = generateId();
        task.setId(id);
        tasks.add(task);
    }

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

    public void updateTaskName(String id, String name) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setName(name);
            }
        }
    }

    public void updateTaskDescription(String id, String description) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDescription(description);
            }
        }
    }

    public void deleteTask(String id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task findTaskById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

}
