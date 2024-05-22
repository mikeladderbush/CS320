package com.projectonecs320;

import com.projectonecs320.Services.AppointmentService;
import com.projectonecs320.Services.ContactService;
import com.projectonecs320.Services.TaskService;

public class Main {
    public static void main(String[] args) {

        TaskService taskService = new TaskService();
        AppointmentService appointmentService = new AppointmentService(taskService);
        ContactService contactService = new ContactService(appointmentService, taskService);
    }
}