package scheduler;

import java.util.Date;

public class Appointment {
    // use `final` to ensure this cannot be edited once set
    private final String ID;
    // use the `Date` class per requirements
    private Date date;
    private String description;

    /**
     * Basic constructor
     *
     * @param ID the ID string to be assigned
     */
    public Appointment(String ID) {
        // validate that the ID is within constraints
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        this.ID = ID;
        // set the date to right now
        date = new Date();
        // set a blank description
        description = "";
    }

    /**
     * Full constructor
     *
     * @param ID the ID string to be assigned
     * @param date the date of the appointment
     * @param description the description to be assigned
     */
    public Appointment(String ID, Date date, String description) {
        // validate the arguments
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Invalid Date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.ID = ID;
        this.date = date;
        this.description = description;
    }

    /**
     * Getter for the ID property
     *
     * @return this object's ID property
     */
    public String getID() {
        return ID;
    }

    /**
     * Getter for the date property
     *
     * @return this object's date property
     */
    public Date getDate() {
        return date;
    }

    /**
     * setter for the date property
     *
     * @param date the date to be assigned
     */
    public void setDate(Date date) {
        // validate the input
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Invalid Date");
        }
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
