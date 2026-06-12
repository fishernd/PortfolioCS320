package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import scheduler.Contact;
import scheduler.ContactService;

class ContactServiceTest {
    private static ContactService cs;
    private Contact ct0;
    private Contact ct1;

    // Setup an object with the bits we need for our tests
    private ContactServiceTest() {
        cs = ContactService.getInstance();
        ct0 = cs.addContact();
        ct1 = cs.addContact();
    }

    @Test
    // Test that our object was intialized correctly and the objects we will be
    // testing are not null.
    void testContactServiceNotNull() {
        assertNotNull(cs);
        assertNotNull(ct0);
        assertNotNull(ct1);
    }

    @Test
    // Test to determine whether our strategy for generating unique IDs is working
    void testIncrementId() {
        /*
         * Note: we don't know what order JUnit will run the tests in, and it will
         * reconstruct cs for each test case, because JUnit is dumb about that
         * (apparently). That will lead to the ID numbers for id0 and id1 not being
         * reliable. We just need to test that they are not equal, and that ct1.ID
         * is one greater than ct0.ID.
         */
        var id0 = Integer.parseInt(ct0.getID());
        var id1 = Integer.parseInt(ct1.getID());
        assertNotEquals(id0, id1);
        assertEquals(id0 + 1, id1);
    }

    @Test
    // Test retreiving a contact
    void testGetContact() {
        var ct = cs.getContact("0");
        assertNotNull(ct);
        assertEquals(ct.getID(), "0");
    }

    @Test
    // Test that trying to retrieve a nonexistent Contact ID returns null
    void testGetNonexistentContact() {
        assertNull(cs.getContact("42"));
    }

    @Test
    // Test updating a Contact's firstName
    void testUpdateContactFirstName() {
        assertTrue(cs.updateContactFirstName("0", "Bob"));
        assertEquals(cs.getContact("0").getFirstName(), "Bob");
    }

    @Test
    // Test updating a Contact's lastName
    void testUpdateContactLastName() {
        assertTrue(cs.updateContactLastName("0", "Johanssen"));
        assertEquals(cs.getContact("0").getLastName(), "Johanssen");
    }

    @Test
    // Test updating a nonexistent Contact, which should return false in each case
    void testUpdateContactNonexistent() {
        assertFalse(cs.updateContactFirstName("42", "Arthur"));
        assertFalse(cs.updateContactLastName("42", "Dent"));
        assertFalse(cs.updateContactPhone("42", "5555555555"));
        assertFalse(cs.updateContactAddress("42", "1313 Mockingbird Lane"));
    }

    @Test
    // Test updating a Contact's phone number
    void testUpdateContactPhone() {
        assertTrue(cs.updateContactPhone("1", "5556060842"));
        assertEquals(cs.getContact("1").getPhone(), "5556060842");
    }

    @Test
    // Test updating a Contact's address
    void testUpdateContactAddress() {
        assertTrue(cs.updateContactAddress("1", "1313 Mockingbird Lane"));
        assertEquals(cs.getContact("1").getAddress(), "1313 Mockingbird Lane");
    }

    @Test
    // Test removing a Contact
    void testRemoveContact() {
        var ct = cs.addContact();
        var id = ct.getID();
        assertTrue(cs.removeContact(id));
        assertNull(cs.getContact(id));
    }

    @Test
    // Test attempting to remove a nonexistent Contact.
    void testRemoveNonexistentContact() {
        assertNull(cs.getContact("42"));
        assertFalse(cs.removeContact("42"));
        assertNull(cs.getContact("42"));
    }
}
