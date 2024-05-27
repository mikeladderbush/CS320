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
    private String email;
    private String phone;
    private String address;
    private List<PaymentOption> paymentOptions;
    private List<Appointment> appointments;

    public static class ContactBuilder {

        private String id;
        private String firstName = "NO FIRST NAME ON FILE";
        private String lastName = "NO LAST NAME ON FILE";
        private String phone = "NO EMAIL ON FILE";
        private String email = "NO PHONE NUMBER ON FILE";
        private String address = "NO ADDRESS ON FILE";
        private List<PaymentOption> paymentOptions = null;
        private List<Appointment> appointments = null;

        public ContactBuilder(String id) {
            this.id = id;
        }

        public ContactBuilder firstName(String value) {
            this.firstName = value;
            return this;
        }

        public ContactBuilder lastName(String value) {
            this.lastName = value;
            return this;
        }

        public ContactBuilder phone(String value) {
            this.phone = value;
            return this;
        }

        public ContactBuilder email(String value) {
            this.email = value;
            return this;
        }
        
        public ContactBuilder address(String value) {
            this.address = value;
            return this;
        }

        public ContactBuilder paymentOptions(List<PaymentOption> value) {
            this.paymentOptions = value;
            return this;
        }

        public ContactBuilder appointments(List<Appointment> value) {
            this.appointments = value;
            return this;
        }

        public Contact buildContact() {
            return new Contact(this);
        }
    }

    private Contact(ContactBuilder contactBuilder) {
        id = contactBuilder.id;
        firstName = contactBuilder.firstName;
        lastName = contactBuilder.lastName;
        phone = contactBuilder.phone;
        email = contactBuilder.email;
        address = contactBuilder.address;
        paymentOptions = contactBuilder.paymentOptions;
        appointments = contactBuilder.appointments;
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
     * For testing purpose only.
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
            //ADD EMAIL ERROR CHECKING
        } else {
            throw new IllegalArgumentException("Email error");
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

    public void addPaymentOption(PaymentOption paymentOption) {
        paymentOptions.add(paymentOption);
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        if (paymentOptions == null) {
            this.paymentOptions = new ArrayList<>();
        } else {
            this.paymentOptions = paymentOptions;
        }
    }

    /**
     * Adds an appointment to the list of appointments for the contact.
     * 
     * @param appointment The appointment to be added.
     */
    public void addAppointment(Appointment appointment) {
        if (appointments != null) {
            appointments.add(appointment);
        } else {
            appointments = new ArrayList<>();
            appointments.add(appointment);
        }
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
