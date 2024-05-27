package com.projectonecs320.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Interfaces.ServiceInterface;

/**
 * Manages operations related to contacts.
 */
public class ContactService implements ServiceInterface{

    private List<Contact> contacts;
    private AppointmentService appointmentService;
    private PaymentOptionService paymentOptionService;

    /**
     * Constructs a ContactService with an empty list of contacts.
     */
    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Constructs a ContactService with an empty list of contacts and a reference to the AppointmentService.
     * 
     * @param appointmentService The AppointmentService used to manage appointments associated with contacts.
     */
    public ContactService(AppointmentService appointmentService) {
        this.contacts = new ArrayList<>();
        this.appointmentService = appointmentService;
    }

    public ContactService(PaymentOptionService paymentOptionService) {
        this.contacts = new ArrayList<>();
        this.paymentOptionService = paymentOptionService;
    }

    public ContactService(AppointmentService appointmentService, PaymentOptionService paymentOptionService) {
        this.contacts = new ArrayList<>();
        this.paymentOptionService = paymentOptionService;
        this.appointmentService = appointmentService;
    }

    /**
     * Adds a contact to the list of contacts.
     * 
     * @param contact The contact to add.
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    /**
     * Associates an appointment with a specific contact.
     * 
     * @param contactId The ID of the contact.
     * @param appointmentId The ID of the appointment to be associated.
     * @throws IllegalArgumentException if the contact or appointment is not found.
     */
    public void addAppointmentToContact(String contactId, String appointmentId) {
        Contact contact = findContactById(contactId);
        if (contact != null) {
            Appointment appointment = appointmentService.findAppointmentById(appointmentId);
            if (appointment != null) {
                contact.addAppointment(appointment);
            } else {
                throw new IllegalArgumentException("Appointment not found");
            }
        } else {
            throw new IllegalArgumentException("Contact not found");
        }
    }

    /**
     * Generates a random ID for contacts.
     * 
     * @return A randomly generated ID for contacts.
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
     * Updates the first name of a contact with the specified ID.
     * 
     * @param id The ID of the contact.
     * @param firstName The new first name.
     */
    public void updateContactFirstName(String id, String firstName) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setFirstName(firstName);
            }
        }
    }

    /**
     * Updates the last name of a contact with the specified ID.
     * 
     * @param id The ID of the contact.
     * @param lastName The new last name.
     */
    public void updateContactLastName(String id, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setLastName(lastName);
            }
        }
    }

    /**
     * Updates the phone number of a contact with the specified ID.
     * 
     * @param id The ID of the contact.
     * @param phone The new phone number.
     */
    public void updateContactPhone(String id, String phone) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setPhone(phone);
            }
        }
    }

    /**
     * Updates the address of a contact with the specified ID.
     * 
     * @param id The ID of the contact.
     * @param address The new address.
     */
    public void updateContactAddress(String id, String address) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setAddress(address);
            }
        }
    }

    /**
     * Deletes a contact with the specified ID.
     * 
     * @param id The ID of the contact to delete.
     */
    public void deleteContact(String id) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    /**
     * Retrieves all contacts.
     * 
     * @return A list of all contacts.
     */
    public List<Contact> getAllContacts() {
        return contacts;
    }

    /**
     * Finds and retrieves a contact by its ID.
     * 
     * @param id The ID of the contact to find.
     * @return The contact with the specified ID, or null if not found.
     */
    public Contact findContactById(String id) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }
}
