package com.projectonecs320;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Classes.Task;
import com.projectonecs320.Services.AppointmentService;
import com.projectonecs320.Services.ContactService;
import com.projectonecs320.Services.TaskService;
import com.projectonecs320.Suppliers.AppointmentSupplier;
import com.projectonecs320.Suppliers.ContactSupplier;
import com.projectonecs320.Suppliers.TaskSupplier;

public class Main {
    public static void main(String[] args) {

        // Initialize services
        TaskService taskService = new TaskService();
        AppointmentService appointmentService = new AppointmentService(taskService);
        ContactService contactService = new ContactService(appointmentService);

        // Create suppliers with their respective services
        ContactSupplier contactSupplier = new ContactSupplier(contactService);
        AppointmentSupplier appointmentSupplier = new AppointmentSupplier(appointmentService);
        TaskSupplier taskSupplier = new TaskSupplier(taskService);

        // Generate and add a contact
        Contact contact = contactSupplier.get();
        contactService.addContact(contact);

        // Generate and add an appointment
        Appointment appointment = appointmentSupplier.get();
        appointmentService.addAppointment(appointment);

        // Generate and add a task
        Task task = taskSupplier.get();
        taskService.addTask(task);

        // Link task to appointment
        appointmentService.addTaskToAppointment(appointment.getId(), task.getId());

        // Link appointment to contact
        contactService.addAppointmentToContact(contact.getId(), appointment.getId());

        // Retrieve all contacts, appointments, and tasks
        System.out.println("Contacts:");
        for (Contact c : contactService.getAllContacts()) {
            System.out.println("Contact ID: " + c.getId());
        }

        System.out.println("\nAppointments:");
        for (Appointment a : appointmentService.getAllAppointments()) {
            System.out.println("Appointment ID: " + a.getId());
        }

        System.out.println("\nTasks:");
        for (Task t : taskService.getAllTasks()) {
            System.out.println("Task ID: " + t.getId());
        }
    }
}
