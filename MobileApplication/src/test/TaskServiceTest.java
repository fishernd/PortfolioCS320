package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import scheduler.TaskService;
import scheduler.Task;

class TaskServiceTest {
    private static TaskService ts;
    private Task t0;
    private Task t1;

    private TaskServiceTest() {
        ts = TaskService.getInstance();
        t0 = ts.addTask();
        t1 = ts.addTask();
    }

    @Test
    void testTaskServiceClass() {
        assertNotNull(ts);
        assertNotNull(t0);
        assertNotNull(t1);
    }

    @Test
    // Test to determine whether our strategy for generating unique IDs is working
    void testIncrementId() {
        /*
         * Note: see note for ContactServiceTest.testIncrementId()
         */
        var id0 = Integer.parseInt(t0.getID());
        var id1 = Integer.parseInt(t1.getID());
        assertNotEquals(id0, id1);
        assertEquals(id0 + 1, id1);
    }

    @Test
    // Test retrieving a task
    void testGetContact() {
        var ct = ts.getTask("0");
        assertNotNull(ct);
        assertEquals(ct.getID(), "0");
    }

    @Test
    // Test that trying to retrieve a nonexistent Task ID returns null
    void testGetNonexistentContact() {
        assertNull(ts.getTask("42"));
    }

    @Test
    // Test updating a Task's name
    void testUpdateTaskName() {
        assertTrue(ts.updateTaskName("0", "task0"));
        assertEquals(ts.getTask("0").getName(), "task0");
    }

    @Test
    // Test updating a Task's description
    void testUpdateTaskDescription() {
        assertTrue(ts.updateTaskDescription("0", "The first task"));
        assertEquals(ts.getTask("0").getDescription(), "The first task");
    }

    @Test
    // Test updating a nonexistent task
    void testUpdateTaskNonexistent() {
        assertFalse(ts.updateTaskName("42", ""));
        assertFalse(ts.updateTaskDescription("42", ""));
    }

    @Test
    // Test removing a task
    void testRemoveTask() {
        Task t = ts.addTask();
        var ID = t.getID();
        assertNotNull(ts.getTask(ID));
        assertTrue(ts.removeTask(ID));
        assertNull(ts.getTask(ID));
    }

    @Test
    // Test removing a nonexistent task
    void testRemoveTaskNonexistent() {
        assertNull(ts.getTask("42"));
        assertFalse(ts.removeTask("42"));
    }
}
