package scheduler;

import java.util.HashMap;

public class AppointmentService {
    // This class will be a singleton, so set up a static instance
    private static AppointmentService instance;
    // ID's for each Task will be numeric, and sequentially assigned. This property
    // will be incremented at each assignment. The result is then converted to a
    // String for use in the Task object constructor.
    private static long nextId = 0;
    // Task objects are to be retrieved and updated based on the ID string. Store
    // them in a HashMap with each Task keyed to its ID property.
    private HashMap<String, Appointment> appointments;

    /**
     * The constructor is private, for use in the singleton pattern
     */
    private AppointmentService() {
        appointments = new HashMap<String, Appointment>();
    }

    /**
     * Gets the default instance of this class, creating it if first it is null
     *
     * @return The instance
     */
    public static AppointmentService getInstance() {
        if (instance == null) {
            // instance is null, so create it here
            instance = new AppointmentService();
        }
        return instance;
    }

    /**
     * Adds a new appointment with a unique ID, putting it into our
     * HashMap keyed to its ID string.
     * 
     * @return the newly created Appointment
     */
    public Appointment addAppointment() {
        // Get the next id as a long int, then increment nextInt
        long id = nextId++;
        // Convert that value to a String
        String ID = String.valueOf(id);

        // Create and store the new Appointment object
        Appointment appointment = new Appointment(ID);
        appointments.put(ID, appointment);
        return appointment;
    }

    /**
     * Retrieves an Appointment if one is found with a matching ID
     * 
     * @param ID the ID String of the Appointment to look for
     * @return the Appointment object, if found, or else null.
     */
    public Appointment getAppointment(String ID) {
        return appointments.get(ID);
    }

    /**
     * Removes an Appointment from the internal HashMap if one exists with a matching ID
     * 
     * @param ID the ID of the Appointment to be removed
     * @return true if the Appointment with the specified ID is found, or else null.
     */
    public boolean removeAppointment(String ID) {
        return (appointments.remove(ID) != null);
    }
}
