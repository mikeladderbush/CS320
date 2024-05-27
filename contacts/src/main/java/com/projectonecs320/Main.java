package com.projectonecs320;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Classes.Task;
import com.projectonecs320.Factories.ContactFactory;
import com.projectonecs320.Services.AppointmentService;
import com.projectonecs320.Services.ContactService;
import com.projectonecs320.Services.TaskService;
import com.projectonecs320.Suppliers.AppointmentSupplier;
import com.projectonecs320.Suppliers.TaskSupplier;

public class Main {
    public static void main(String[] args) {

        // Initialize services
        TaskService taskService = new TaskService();
        AppointmentService appointmentService = new AppointmentService();
        ContactService contactService = new ContactService();

        // Create suppliers with their respective services
        AppointmentSupplier appointmentSupplier = new AppointmentSupplier(appointmentService);
        TaskSupplier taskSupplier = new TaskSupplier(taskService);

        // Create contact using factory
        Contact contact = ContactFactory.createContact();
        contactService.addContact(contact);

        // Generate and add an appointment
        Appointment appointment = appointmentSupplier.get();
        Appointment appointment2 = appointmentSupplier.get();
        Appointment appointment3 = appointmentSupplier.get();
        appointmentService.addAppointment(appointment);
        appointmentService.addAppointment(appointment2);
        appointmentService.addAppointment(appointment3);

        // Generate and add a task
        Task task = taskSupplier.get();
        Task task2 = taskSupplier.get();
        Task task3 = taskSupplier.get();
        Task task4 = taskSupplier.get();
        Task task5 = taskSupplier.get();
        Task task6 = taskSupplier.get();
        taskService.addTask(task);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);
        taskService.addTask(task5);
        taskService.addTask(task6);

        // Link task to appointment
        appointmentService.addTaskToAppointment(appointment, task);
        appointmentService.addTaskToAppointment(appointment, task2);
        appointmentService.addTaskToAppointment(appointment2, task3);
        appointmentService.addTaskToAppointment(appointment2, task4);
        appointmentService.addTaskToAppointment(appointment3, task5);
        appointmentService.addTaskToAppointment(appointment3, task6);


        // Link appointment to contact
        contactService.addAppointmentToContact(contact, appointment);
        contactService.addAppointmentToContact(contact, appointment2);
        contactService.addAppointmentToContact(contact, appointment3);


        // Retrieve all contacts, appointments, and tasks
        for (Contact c : contactService.getAllContacts()) {
            System.out.println("Contact ID: " + c.getId());
            System.out.println("Contact First Name: " + c.getFirstName());
            System.out.println("Contact Last Name: " + c.getLastName());
            System.out.println("Contact Email: " + c.getEmail());
            System.out.println("Contact Phone Number: " + c.getAddress());
            int appointmentNum = 1;
            for (Appointment a : appointmentService.getAllAppointments()) {
                System.out.println(c.getId() + "'s Appointment "+ appointmentNum + " " + a.getId());
                appointmentNum++;
                int taskNum = 1;
                for (Task t : a.getTasks()) { // Iterate over tasks associated with the current appointment
                    System.out.println(a.getId() + "'s Task " + taskNum + " " + t.getId());
                    taskNum++;
                }
            }
        }
        
    }
}
