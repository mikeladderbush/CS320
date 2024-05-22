package com.projectonecs320.Suppliers;

import java.util.function.Supplier;

import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Services.ContactService;

public class ContactSupplier implements Supplier<Contact> {

    private ContactService contactService;

    public ContactSupplier(ContactService contactService) {
        this.contactService = contactService;
    }
    
    @Override
    public Contact get() {
        return new Contact(contactService.generateId());
    }
    
}
