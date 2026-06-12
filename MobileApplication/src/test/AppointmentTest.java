package test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import scheduler.Appointment;

import org.junit.jupiter.api.Test;

class AppointmentTest {

    @Test
    // Test the basic constructor
    void testAppointmentClass() {
        var a = new Appointment("123");
        assertNotNull(a);
        assertEquals(a.getID(), "123");
    }

    @Test
    // Test the full constructor
    void testAppointmentClassFull() {
        var date = new Date();
        var a = new Appointment("123", date, "Test appointment");
        assertNotNull(a);
        assertEquals(a.getID(), "123");
        assertEquals(a.getDate(), date);
        assertEquals(a.getDescription(), "Test appointment");
    }

    @Test
    // Test that an exception is thrown when the ID is too long
    void testIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("01234567890123");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("01234567890123", new Date(), "");
        });
    }

    @Test
    // Test that an exception is thrown when the ID is null
    void testIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "");
        });
    }
    
    @Test
    // Test getting and setting the date property
    void testGetSetDate() {
        var a = new Appointment("123");
        var date = (Date)a.getDate().clone(); // Clone this so that it is a new object
        date.setMonth(date.getMonth() + 1);
        a.setDate(date);
        assertEquals(date, a.getDate());
    }

    @Test
    // Test getting and setting the description property
    void testGetSetDescription() {
        var a = new Appointment("123");
        assertEquals(a.getDescription(), "");
        a.setDescription("Test appointment");
        assertEquals(a.getDescription(), "Test appointment");
    }

    @Test
    // Test that an exception is thrown when the date is null
    void testSetDateNull() {
        var a = new Appointment("123");
        assertThrows(IllegalArgumentException.class, () -> {
            a.setDate(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", null, "");
        });
    }

    @Test
    // Test that an exception is thrown when the date is in the past
    void testSetDatePast() {
        var a = new Appointment("123");
        assertThrows(IllegalArgumentException.class, () -> {
            a.setDate(new Date(0));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(0), "");
        });
    }
    
    @Test
    // Test that an exception is thrown when the description is null
    void testSetDescriptionNull() {
        var a = new Appointment("123");
        assertThrows(IllegalArgumentException.class, () -> {
            a.setDescription(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(), null);
        });
    }

    @Test
    // Test that an exception is thrown when the date is too long
    void testSetDescriptionTooLong() {
        var a = new Appointment("123");
        assertThrows(IllegalArgumentException.class, () -> {
            a.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        });
    }
}
