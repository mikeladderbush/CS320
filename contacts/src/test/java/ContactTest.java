import org.junit.Test;

import com.projectonecs320.Contact;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testContactConstructor() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        assertEquals("1", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testSetIdValid() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        contact.setId("2");
        assertEquals("2", contact.getId());
    }

    @Test
    public void testSetIdTooLong() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setId("12345678901");
        });
    }

    @Test
    public void testSetFirstNameValid() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisIsTooLong");
        });
    }

    @Test
    public void testSetLastNameValid() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        contact.setLastName("Jane");
        assertEquals("Jane", contact.getLastName());
    }

    @Test
    public void testSetLastNameTooLong() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ThisIsTooLong");
        });
    }

    @Test
    public void testSetPhoneValid() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        contact.setPhone("1234567890");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    public void testSetPhoneIncorrectLength() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("ThisIsTooLong");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("tooShort");
        });
    }

    @Test
    public void testSetAddressValid() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        contact.setAddress("123 Main St");
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testSetAddressLength() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St", null);

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(
                    "ThisIsTooLongfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        });

    }

}
