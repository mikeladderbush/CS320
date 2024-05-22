package com.projectonecs320.Classes;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private List<Appointment> appointments;

    public Contact(String id) {
        this.id = id;
        this.appointments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name must be fewer than 10 characters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name must be fewer than 10 characters");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && phone.length() == 10) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone number must be in exactly 10 character format");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address must be fewer than 30 characters");
        }
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        if (appointments == null) {
            this.appointments = new ArrayList<>();
        } else {
            this.appointments = appointments;
        }
    }
}
