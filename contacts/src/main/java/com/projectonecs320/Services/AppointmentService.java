package com.projectonecs320.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Task;
import com.projectonecs320.Interfaces.ServiceInterface;

/**
 * Manages operations related to appointments.
 */
public class AppointmentService implements ServiceInterface{

    private List<Appointment> appointments;
    private TaskService taskService;

    /**
     * Constructs an AppointmentService with an empty list of appointments.
     */
    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    /**
     * Constructs an AppointmentService with an empty list of appointments and a reference to the TaskService.
     * 
     * @param taskService The TaskService used to manage tasks associated with appointments.
     */
    public AppointmentService(TaskService taskService) {
        this.appointments = new ArrayList<>();
        this.taskService = taskService;
    }

    /**
     * Adds an appointment to the list of appointments.
     * 
     * @param appointment The appointment to add.
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * Associates a task with a specific appointment.
     * 
     * @param appointmentId The ID of the appointment.
     * @param taskId The ID of the task to be associated.
     * @throws IllegalArgumentException if the appointment or task is not found.
     */
    public void addTaskToAppointment(String appointmentId, String taskId) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            Task task = taskService.findTaskById(taskId);
            if (task != null) {
                appointment.addTask(task);
            } else {
                throw new IllegalArgumentException("Task not found");
            }
        } else {
            throw new IllegalArgumentException("Appointment not found");
        }
    }

    /**
     * Generates a random ID for appointments.
     * 
     * @return A randomly generated ID for appointments.
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
     * Deletes an appointment with the specified ID.
     * 
     * @param id The ID of the appointment to delete.
     */
    public void deleteAppointment(String id) {
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    /**
     * Retrieves all appointments.
     * 
     * @return A list of all appointments.
     */
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    /**
     * Finds and retrieves an appointment by its ID.
     * 
     * @param id The ID of the appointment to find.
     * @return The appointment with the specified ID, or null if not found.
     */
    public Appointment findAppointmentById(String id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }
}
