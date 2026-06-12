package scheduler;

import java.util.HashMap;

public class TaskService {
    // This class will be a singleton, so set up a static instance
    private static TaskService instance;
    // ID's for each Task will be numeric, and sequentially assigned. This property
    // will be incremented at each assignment. The result is then converted to a
    // String for use in the Task object constructor.
    private static long nextId = 0;
    // Task objects are to be retrieved and updated based on the ID string. Store
    // them in a HashMap with each Task keyed to its ID property.
    private HashMap<String, Task> taskMap;

    /**
     * The constructor is private, for use in the singleton pattern
     */
    private TaskService() {
        taskMap = new HashMap<String, Task>();
    }

    /**
     * Gets the default instance of this class, creating it if first it is null
     *
     * @return The instance
     */
    public static TaskService getInstance() {
        if (instance == null) {
            // instance is null, so create it here
            instance = new TaskService();
        }
        return instance;
    }

    /**
     * Adds a new task with a unique ID, putting it into our
     * HashMap keyed to its ID string.
     * 
     * @return the newly created Task
     */
    public Task addTask() {
        // Get the next id as a long int, then increment nextInt
        long id = nextId++;
        // Convert that value to a String
        String ID = String.valueOf(id);

        // Create and store the new Task object
        Task task = new Task(ID);
        taskMap.put(ID, task);

        return task;
    }

    /**
     * Retrieves a Task if one is found with a matching ID
     * 
     * @param ID the ID String of the Task to look for
     * @return the Task object, if found, or else null.
     */
    public Task getTask(String ID) {
        return taskMap.get(ID);
    }

    /**
     * Removes a Task from the internal HashMap if one exists with a matching ID
     * 
     * @param ID the ID of the Task to be removed
     * @return true if the Task with the specified ID is found, or else null.
     */
    public boolean removeTask(String ID) {
        return (taskMap.remove(ID) != null);
    }

    /**
     * Updates the name of the Task with the given ID, if it exists
     * 
     * @param ID the ID of the Task to be updated
     * @param name the name to assign to this Task
     * 
     * @return true if the Task with the specified ID is found and updated,
     * or else null.
     */
    public boolean updateTaskName(String ID, String name) {
        Task t = taskMap.get(ID);
        if (t == null) {
            return false;
        } else {
            t.setName(name);
            return true;
        }
    }

    /**
     * Updates the description of the Task with the given ID, if it exists
     * 
     * @param ID the ID of the Task to be updated
     * @param description the description to assign to this Task
     * 
     * @return true if the Task with the specified ID is found and updated,
     * or else null.
     */
    public boolean updateTaskDescription(String ID, String description) {
        Task t = taskMap.get(ID);
        if (t == null) {
            return false;
        } else {
            t.setDescription(description);
            return true;
        }
    }
}
