package scheduler;

public class Task {
    // Use `final` so that once set the ID cannot be changed
    private final String ID;
    private String name;
    private String description;

    /**
     * Basic constructor
     *
     * @param ID the ID to be assigned
     */
    public Task(String ID) {
        // Validate that the ID is within the given constraints
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        this.ID = ID;
        // Just set empty strings as a default
        name = "";
        description = "";
    }

    /**
     * Constructor with arguments for all fields
     *
     * @param ID the ID to be assigned
     * @param name the name to be assigned
     * @param description the description to be assigned
     */
    public Task(String ID, String name, String description) {
        // Validate the arguments against the given constraints
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.ID = ID;
        this.name = name;
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
     * Getter for the name property
     *
     * @return this object's name property
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name property
     *
     * @param name the name to be assigned
     */
    public void setName(String name) {
        // Validate the argument against the given constraints
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    /**
     * Getter for the description property
     *
     * @return this object's description property
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the description property
     *
     * @param description the description to be assigned
     */
    public void setDescription(String description) {
        // Validate the argument against the given constraints
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
