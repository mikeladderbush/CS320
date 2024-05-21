
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.*;

import com.projectonecs320.Contact;
import com.projectonecs320.ContactService;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @Before
    public void setUp() {
        contactService = new ContactService(null, null);
        contact = new Contact(contactService.generateId(), "John", "Doe", "1234567890", "123 Main St", null);
    }

    @Test
    public void testAddContact() {
        contactService.addContact();
        assertEquals(1, contactService.getAllContacts().size());
    }

    @Test
    public void testUpdateFirstName() {
        contactService.addContact();
        contactService.updateContactFirstName(contact.getId(), "Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        contactService.addContact();
        contactService.updateContactLastName(contact.getId(), "Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testFindContactById() {
        contactService.addContact();

        Contact foundContact = contactService.findContactById(contact.getId());
        assertNotNull(foundContact);
        assertEquals(contact, foundContact);
    }

    @Test
    public void testUpdateFirstNameWithInvalidName() {
        contactService.addContact();

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName(contact.getId(), "ThisIsTooLong");
        });
        assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact();

        contactService.deleteContact(contact.getId());
        assertEquals(0, contactService.getAllContacts().size());
    }
}
