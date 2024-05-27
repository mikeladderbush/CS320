package com.projectonecs320.Factories;

import java.util.List;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Services.ContactService;

public class ContactFactory{

    // Default values for contacts
    private static final String DEFAULT_FIRST_NAME = "NO FIRST NAME ON FILE";
    private static final String DEFAULT_LAST_NAME = "NO LAST NAME ON FILE";
    private static final String DEFAULT_EMAIL = "NO EMAIL ON FILE";
    private static final String DEFAULT_PHONE = "NO PHONE NUMBER ON FILE";
    private static final String DEFAULT_ADDRESS = "NO ADDRESS ON FILE";
    private static final List<Appointment> DEFAULT_APPOINTMENTS = null;

    private static final ContactService contactService = new ContactService();

    // Method to create a contact with default values
    public static Contact createContact() {
        String id = contactService.generateId();
        return new Contact(id, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL, DEFAULT_PHONE, DEFAULT_ADDRESS,
                DEFAULT_APPOINTMENTS);
    }

    public static Contact createContact(String id) {
        return new Contact(id, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL, DEFAULT_PHONE, DEFAULT_ADDRESS,
                DEFAULT_APPOINTMENTS);
    }

    // Method to create a contact with custom values
    public static Contact createContact(String firstName, String lastName, String email, String phone, String address,
            List<Appointment> appointments) {
        String id = contactService.generateId(); // Generate a unique ID
        return new Contact(id, firstName, lastName, email, phone, address, appointments);
    }

    // Method to create a contact with custom values
    public static Contact createContact(String id, String firstName, String lastName, String email, String phone,
            String address, List<Appointment> appointments) {
        return new Contact(id, firstName, lastName, email, phone, address, appointments);
    }

}
