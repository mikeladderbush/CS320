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
        appointmentService.addTaskToAppointment(appointment.getId(), task.getId());
        appointmentService.addTaskToAppointment(appointment.getId(), task2.getId());
        appointmentService.addTaskToAppointment(appointment2.getId(), task3.getId());
        appointmentService.addTaskToAppointment(appointment2.getId(), task4.getId());
        appointmentService.addTaskToAppointment(appointment3.getId(), task5.getId());
        appointmentService.addTaskToAppointment(appointment3.getId(), task6.getId());


        // Link appointment to contact
        contactService.addAppointmentToContact(contact.getId(), appointment.getId());
        contactService.addAppointmentToContact(contact.getId(), appointment2.getId());
        contactService.addAppointmentToContact(contact.getId(), appointment3.getId());


        // Retrieve all contacts, appointments, and tasks
        int contactNum = 1;
        for (Contact c : contactService.getAllContacts()) {
            System.out.println("Contact ID: " + c.getId());
            contactNum++;
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
