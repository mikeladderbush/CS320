package com.projectonecs320.Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment {

    String id;
    Date date;
    String description;
    private List<Task> tasks;

    public Appointment(String id) {
        this.id = id;
        this.tasks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date.before(new Date()) || date == null) {
            throw new IllegalArgumentException("This date is invalid");
        } else {
            this.date = date;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() < 50 && date != null) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("This date is invalid");
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
