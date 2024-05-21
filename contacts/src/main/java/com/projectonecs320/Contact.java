package com.projectonecs320;

import java.util.List;

public class Contact {

    private String Id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private List<Appointment> appointments;

    public Contact(String Id, String firstName, String lastName, String phone, String address) {
        setId(Id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public Contact(String Id, String firstName, String lastName, String phone, String address,
            List<Appointment> appointments) {
        setId(Id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        if (Id != null && Id.length() <= 10) {
            this.Id = Id;
        } else {
            throw new IllegalArgumentException("Id must be fewer than 10 characters");
        }
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

}
