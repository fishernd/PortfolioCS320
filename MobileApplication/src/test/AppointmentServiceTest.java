package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import scheduler.Appointment;
import scheduler.AppointmentService;

class AppointmentServiceTest {
    private static AppointmentService aps;
    private Appointment ap0;
    private Appointment ap1;
    
    private AppointmentServiceTest() {
        aps = AppointmentService.getInstance();
        ap0 = aps.addAppointment();
        ap1 = aps.addAppointment();
    }

    @Test
    void testAppointmentServiceClass() {
        assertNotNull(aps);
        assertNotNull(ap0);
        assertNotNull(ap1);
    }

    @Test
    // Test to determine whether our strategy for generating unique IDs is working
    void testIncrementId() {
        var id0 = Integer.parseInt(ap0.getID());
        var id1 = Integer.parseInt(ap1.getID());
        assertNotEquals(id0, id1);
        assertEquals(id0 + 1, id1);
    }

    @Test
    // Test retrieving a task
    void testGetAppointment() {
        var ap = aps.getAppointment("0");
        assertNotNull(ap);
        assertEquals(ap.getID(), "0");
    }

    @Test
    // Test that trying to retrieve a nonexistent Task ID returns null
    void testGetNonexistentAppointment() {
        assertNull(aps.getAppointment("42"));
    }
    
    @Test
    void testRemoveAppointment() {
        var ap = aps.addAppointment();
        var id = ap.getID();
        assertNotNull(aps.getAppointment(id));
        assertTrue(aps.removeAppointment(id));
        assertNull(aps.getAppointment(id));
    }
    
    @Test
    void testRemoveNonexistentAppointment() {
        assertNull(aps.getAppointment("42"));
        assertFalse(aps.removeAppointment("42"));
    }
}
