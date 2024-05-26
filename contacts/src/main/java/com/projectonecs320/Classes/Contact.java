package com.projectonecs320.Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a contact.
 */
public class Contact {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private List<Appointment> appointments;

    /**
     * Constructs a contact with the specified ID.
     * 
     * @param id The ID of the contact.
     */
    public Contact(String id) {
        this.id = id;
        this.appointments = new ArrayList<>();
    }

    /**
     * Retrieves the ID of the contact.
     * 
     * @return The ID of the contact.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the first name of the contact.
     * 
     * @return The first name of the contact.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the contact.
     * 
     * @param firstName The first name of the contact.
     * @throws IllegalArgumentException if the first name is null or exceeds 10 characters.
     */
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name must be fewer than 10 characters");
        }
    }

    /**
     * Retrieves the last name of the contact.
     * 
     * @return The last name of the contact.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the contact.
     * 
     * @param lastName The last name of the contact.
     * @throws IllegalArgumentException if the last name is null or exceeds 10 characters.
     */
    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name must be fewer than 10 characters");
        }
    }

    /**
     * Retrieves the phone number of the contact.
     * 
     * @return The phone number of the contact.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the contact.
     * 
     * @param phone The phone number of the contact.
     * @throws IllegalArgumentException if the phone number is null or not exactly 10 characters.
     */
    public void setPhone(String phone) {
        if (phone != null && phone.length() == 10) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone number must be in exactly 10 character format");
        }
    }

    /**
     * Retrieves the address of the contact.
     * 
     * @return The address of the contact.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the contact.
     * 
     * @param address The address of the contact.
     * @throws IllegalArgumentException if the address is null or exceeds 30 characters.
     */
    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address must be fewer than 30 characters");
        }
    }

    /**
     * Adds an appointment to the list of appointments for the contact.
     * 
     * @param appointment The appointment to be added.
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * Retrieves the list of appointments for the contact.
     * 
     * @return The list of appointments for the contact.
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Sets the list of appointments for the contact.
     * 
     * @param appointments The list of appointments for the contact.
     */
    public void setAppointments(List<Appointment> appointments) {
        if (appointments == null) {
            this.appointments = new ArrayList<>();
        } else {
            this.appointments = appointments;
        }
    }
}
