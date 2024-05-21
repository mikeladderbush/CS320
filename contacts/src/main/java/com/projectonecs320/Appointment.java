package com.projectonecs320;

import java.util.Date;
import java.util.List;

public class Appointment {

    String id;
    Date date;
    String description;
    private List<Task> tasks;

    public Appointment(String Id, Date date, String description) {
        setId(Id);
        setDate(date);
        setDescription(description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() <= 10 && id != null) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("This id is invalid");
        }
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

}
