package com.projectonecs320;

public class Main {
    public static void main(String[] args) {

        TaskService taskService = new TaskService();
        AppointmentService appointmentService = new AppointmentService(taskService);
        ContactService contactService = new ContactService(appointmentService, taskService);
    }
}