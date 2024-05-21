package com.projectonecs320;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AppointmentService {

    private List<Appointment> appointments;
    private TaskService taskService;

    public AppointmentService(TaskService taskService) {
        this.appointments = new ArrayList<>();
        this.taskService = taskService;
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

    public void addAppointment(Appointment appointment) {
        String appointmentId = generateId();
        appointment.setId(appointmentId);
        appointments.add(appointment);
    }

    public void addTask(String appointmentId, Task task) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            taskService.addTask(task);
            appointment.addTask(task);
        } else {
            throw new IllegalArgumentException("Contact not found");
        }
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

    public Appointment findAppointmentById(String id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

}
