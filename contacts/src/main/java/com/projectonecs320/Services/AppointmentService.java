package com.projectonecs320.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Task;

public class AppointmentService {

    private List<Appointment> appointments;
    private TaskService taskService;

    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    public AppointmentService(TaskService taskService) {
        this.appointments = new ArrayList<>();
        this.taskService = taskService;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

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

    public void deleteAppointment(String id) {
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment findAppointmentById(String id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }

}
