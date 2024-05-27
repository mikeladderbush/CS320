package com.projectonecs320.Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an appointment.
 */
public class Appointment {

    private String id;
    private Date date;
    private String description;
    private List<Task> tasks;

    public static class AppointmentBuilder {

        private String id;
        private Date date = new Date();
        private String description = "DEFAULT_DESCRIPTION";
        private List<Task> tasks = new ArrayList<>();

        public AppointmentBuilder(String id) {
            this.id = id;
        }

        public AppointmentBuilder date(Date value) {
            this.date = value;
            return this;
        }

        public AppointmentBuilder description(String value) {
            this.description = value;
            return this;
        }

        public AppointmentBuilder tasks(List<Task> value) {
            this.tasks = value;
            return this;
        }

        public Appointment buildAppointment() {
            return new Appointment(this);
        }
    }

    private Appointment(AppointmentBuilder appointmentBuilder) {
        id = appointmentBuilder.id;
        date = appointmentBuilder.date;
        description = appointmentBuilder.description;
        tasks = appointmentBuilder.tasks;
    }

    /**
     * Retrieves the ID of the appointment.
     * 
     * @return The ID of the appointment.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the date of the appointment.
     * 
     * @return The date of the appointment.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the appointment.
     * 
     * @param date The date of the appointment.
     * @throws IllegalArgumentException if the date is null or before the current
     *                                  date.
     */
    public void setDate(Date date) {
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Invalid date for appointment");
        } else {
            this.date = date;
        }
    }

    /**
     * Retrieves the description of the appointment.
     * 
     * @return The description of the appointment.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the appointment.
     * 
     * @param description The description of the appointment.
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

    /**
     * Adds a task to the appointment.
     * 
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Retrieves the list of tasks associated with the appointment.
     * 
     * @return The list of tasks associated with the appointment.
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
