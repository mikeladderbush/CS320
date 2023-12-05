package com.projectonecs320;

public class Task {
    private String Id;
    private String name;
    private String description;

    public Task(String Id, String name, String description) {
        setId(Id);
        setName(name);
        setDescription(description);
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        if (Id != null && Id.length() <= 10) {
            this.Id = Id;
        } else {
            throw new IllegalArgumentException("Id must be fewer than 10 characters and not null.");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() <= 20) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must be fewer than 20 characters and not null");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() <= 50) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description must be 50 characters or fewer and not null.");
        }
    }
}