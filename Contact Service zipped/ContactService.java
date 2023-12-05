package com.projectonecs320;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        String id = generateId();
        contact.setId(id);
        contacts.add(contact);
    }

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

    public void updateContactFirstName(String id, String firstName) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setFirstName(firstName);
            }
        }
    }

    public void updateContactLastName(String id, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setLastName(lastName);
            }
        }
    }

    public void updateContactPhone(String id, String phone) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setPhone(phone);
            }
        }
    }

    public void updateContactAddress(String id, String address) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contact.setAddress(address);
            }
        }
    }

    public void deleteContact(String id) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public Contact findContactById(String id) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }

}
