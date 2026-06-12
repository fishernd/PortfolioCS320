package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import scheduler.Task;

class TaskTest {

    @Test
    // Test the basic constructor
    void testTaskClass() {
        Task t = new Task("12345");
        assertNotNull(t);
        assertEquals(t.getID(), "12345");
    }

    @Test
    // Test the full constructor
    void testTaskClassFull() {
        Task t = new Task("12345", "task0", "A made up task");
        assertNotNull(t);
        assertEquals(t.getID(), "12345");
        assertEquals(t.getName(), "task0");
        assertEquals(t.getDescription(), "A made up task");
    }

    @Test
    // Test that an exception is thrown when the ID is too long
    void testIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("01234567890");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("01234567890", "", "");
        });
    }

    @Test
    // Test that an exception is thrown when the ID is null
    void testIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "", "");
        });
    }

    @Test
    // Test getting and setting the name property
    void testGetSetName() {
        Task t = new Task("12345");
        assertEquals(t.getName(), "");
        t.setName("task1");
        assertEquals(t.getName(), "task1");
    }

    @Test
    // test getting and setting the description
    void taskGetSetDesciption() {
        Task t = new Task("12345");
        assertEquals(t.getDescription(), "");
        t.setDescription("A made up task");
        assertEquals(t.getDescription(), "A made up task");
    }

    @Test
    // Test that an exception is thrown when the name is null
    void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "");
        });
        Task t = new Task("123");
        assertThrows(IllegalArgumentException.class, () -> {
            t.setName(null);
        });
    }

    @Test
    // Test that an exception is thrown when the name is too long
    void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Alexander James Hamilton", "");
        });
        Task t = new Task("123");
        assertThrows(IllegalArgumentException.class, () -> {
            t.setName("Alexander James Hamilton");
        });
    }

    @Test
    // Tst that an exception is thown when the description is null
    void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "", null);
        });
        Task t = new Task("123");
        assertThrows(IllegalArgumentException.class, () -> {
            t.setDescription(null);
        });
    }

    @Test
    // Test that an exception is thrown when the description is too long
    void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        });
        Task t = new Task("123");
        assertThrows(IllegalArgumentException.class, () -> {
            t.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        });
    }
}
