
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.*;

import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Services.ContactService;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @Before
    public void setUp() {
        contactService = new ContactService(null, null);
        contact = new Contact(contactService.generateId());
    }

    @Test
    public void testAddContact() {
        contactService.addContact(contact);
        assertEquals(1, contactService.getAllContacts().size());
    }

    @Test
    public void testUpdateFirstName() {
        contactService.addContact(contact);
        contactService.updateContactFirstName(contact.getId(), "Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        contactService.addContact(contact);
        contactService.updateContactLastName(contact.getId(), "Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testFindContactById() {
        contactService.addContact(contact);

        Contact foundContact = contactService.findContactById(contact.getId());
        assertNotNull(foundContact);
        assertEquals(contact, foundContact);
    }

    @Test
    public void testUpdateFirstNameWithInvalidName() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName(contact.getId(), "ThisIsTooLong");
        });
        assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact(contact);

        contactService.deleteContact(contact.getId());
        assertEquals(0, contactService.getAllContacts().size());
    }
}
