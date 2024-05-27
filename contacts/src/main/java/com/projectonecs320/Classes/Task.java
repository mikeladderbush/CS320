package com.projectonecs320.Classes;

/**
 * Represents a task.
 */
public class Task {

    private String id;
    private String name;
    private String description;
    private Double quote;

    public static class TaskBuilder {

        private String id;
        private String name = "NO_TASK_NAME_ON_FILE";
        private String description = "NO_TASK_DESCRIPTION_ON_FILE";
        private Double quote = 0.0;

        public TaskBuilder(String id) {
            this.id = id;
        }

        public TaskBuilder name(String value) {
            this.name = value;
            return this;
        }

        public TaskBuilder description(String value) {
            this.description = value;
            return this;
        }

        public TaskBuilder quote(Double value) {
            this.quote = value;
            return this;
        }

        public Task buildTask() {
            return new Task(this);
        }

    }

    private Task(TaskBuilder taskBuilder) {
        id = taskBuilder.id;
        name = taskBuilder.name;
        description = taskBuilder.description;
        quote = taskBuilder.quote;
    }

    /**
     * Retrieves the ID of the task.
     * 
     * @return The ID of the task.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the task.
     * 
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the task.
     * 
     * @param name The name of the task.
     * @throws IllegalArgumentException if the name is null or exceeds 20
     *                                  characters.
     */
    public void setName(String name) {
        if (name != null && name.length() <= 20) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must be fewer than 20 characters and not null");
        }
    }

    /**
     * Retrieves the description of the task.
     * 
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     * 
     * @param description The description of the task.
     * @throws IllegalArgumentException if the description is null or exceeds 50
     *                                  characters.
     */
    public void setDescription(String description) {
        if (description != null && description.length() <= 50) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description must be 50 characters or fewer and not null.");
        }
    }

    public Double getQuote() {
        return quote;
    }

    public void setQuote(Double quote) {
        this.quote = quote;
    }
}
