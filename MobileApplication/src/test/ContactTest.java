package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import scheduler.Contact;

class ContactTest {

    @Test
    // Simple test of Contact creation
    void testContactClass() {
        Contact contact = new Contact("12345");
        assertNotNull(contact);
        assertEquals(contact.getID(), "12345");
    }

    @Test
    // Test Contact creation using the full constructor
    void testContactClassFull() {
        Contact contact = new Contact("12345", "Joe", "Smith", "5556060842", "42 Front ST, Anytown, Ak 12345");
        assertNotNull(contact);
        assertEquals(contact.getID(), "12345");
        assertEquals(contact.getFirstName(), "Joe");
        assertEquals(contact.getLastName(), "Smith");
        assertEquals(contact.getPhone(), "5556060842");
        assertEquals(contact.getAddress(), "42 Front ST, Anytown, Ak 12345");
    }

    @Test
    // Test that an exception is raised for invalid ID inputs
    void testIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890123");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890123", "Joe", "Smith", "5556060842", "42 Front ST, Anytown, Ak 12345");
        });
    }

    @Test
    // Test that an exception is raised for null ID inputs
    void testIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Joe", "Smith", "5556060842", "42 Front ST, Anytown, Ak 12345");
        });
    }

    @Test
    // Test setting and getting the firstName property
    void testGetSetFirstName() {
        Contact c = new Contact("12345");
        assertEquals(c.getFirstName(), "");
        c.setFirstName("Eddie");
        assertEquals(c.getFirstName(), "Eddie");
    }

    @Test
    // Test setting and getting the lastName property
    void testGetSetLastName() {
        Contact c = new Contact("12345");
        assertEquals(c.getLastName(), "");
        c.setLastName("DeHedde");
        assertEquals(c.getLastName(), "DeHedde");
    }

    @Test
    // Test setting and getting the phone property
    void testGetSetPhone() {
        Contact c = new Contact("123");
        assertEquals(c.getPhone(), "0000000000");
        c.setPhone("0123456789");
        assertEquals(c.getPhone(), "0123456789");
    }

    @Test
    // Test setting and getting the address property
    void testGetSetAddress() {
        Contact c = new Contact("123");
        assertEquals(c.getAddress(), "");
        c.setAddress("42 Mockingbird Lane");
        assertEquals(c.getAddress(), "42 Mockingbird Lane");
    }

    @Test
    // Test that an exception is raised for null firstName inputs
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "", "1234567890", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setFirstName(null);
        });
    }

    @Test
    // Test that an exception is raised for invalid firstName inputs
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Freoderiche", "Stein", "0000000000", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setFirstName("Freoderiche");
        });
    }

    @Test
    // Test that an exception is raised for null firstName inputs
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Frederick", null, "1234567890", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setLastName(null);
        });
    }

    @Test
    // Test that an exception is raised for invalid lastName inputs
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Frederick", "Frankenschtein", "0000000000", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setLastName("Frankenschtein");
        });
    }

    @Test
    // Test that an exception is raised for null phone inputs
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Frederick", "Stein", null, "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setPhone(null);
        });
    }

    @Test
    // Test that an exception is raised for too short phone inputs
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Frederick", "Stein", "12345", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setPhone("12345");
        });
    }

    @Test
    // Test that an exception is raised for too long phone inputs
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Frederick", "Stein", "1234567890123", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setPhone("1234567890123");
        });
    }

    @Test
    // Test that an exception is raised for null address inputs
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Frederick", "Stein", "0123456789", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setAddress(null);
        });
    }

    @Test
    // Test that an exception is raised for invalid address inputs
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Frederick", "Stein", "1234567890", "42 Mockingbird Lane, Bogota, Columbia");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact("12345");
            c.setAddress("42 Mockingbird Lane, Bogota, Columbia");
        });
    }
}
