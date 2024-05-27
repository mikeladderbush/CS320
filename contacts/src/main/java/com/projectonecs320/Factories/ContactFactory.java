package com.projectonecs320.Factories;

import java.util.function.Consumer;

import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Services.ContactService;

public class ContactFactory {

    private static final ContactService contactService = new ContactService();

    // Method to create a contact with default values
    public static Contact createContact() {
        String id = contactService.generateId();
        return new Contact.ContactBuilder(id).buildContact();
    }

    public static Contact createContact(Consumer<Contact.ContactBuilder> consumer) {
        String id = contactService.generateId();
        Contact.ContactBuilder builder = new Contact.ContactBuilder(id);
        consumer.accept(builder);
        return builder.buildContact();
    }
}
