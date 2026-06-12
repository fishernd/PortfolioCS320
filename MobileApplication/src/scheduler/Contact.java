package scheduler;

public class Contact {
    // Use `final` so that once set it cannot be changed
    private final String ID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Basic constructor
     * 
     * @param ID the ID to be used
     */
    public Contact(String ID) {
        // Validate that the ID is within requirements
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        // Set the rest of the properties to some default values
        this.ID = ID;
        this.firstName = "";
        this.lastName = "";
        this.phone = "0000000000";
        this.address = "";
    }

    /**
     * Constructor with arguments for all fields
     * 
     * @param ID        the ID to use
     * @param firstName the first name to use
     * @param lastName  the last name to use
     * @param phone     the phone number to use
     * @param address   the address to use
     */
    public Contact(
            String ID,
            String firstName,
            String lastName,
            String phone,
            String address
        ) {
        // Validate the arguments arainst the constraints given in the requirements
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
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
     * Getter for the firstName property
     * 
     * @return this object's firstName property
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the firstName property
     * 
     * @param name the name to be used
     */
    public void setFirstName(String name) {
        // Validate against constraints before setting
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException("Invalid name");
        }
        firstName = name;
    }

    /**
     * Getter for the lastName property
     * 
     * @return this object's lastName property
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the lastName property
     * 
     * @param name the name to be used
     */
    public void setLastName(String name) {
        // Validate against constraints before setting
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException("Invalid name");
        }
        lastName = name;
    }

    /**
     * Getter for the phone property
     * 
     * @return this object's phone property
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter for the phone property
     * 
     * @param phone the phone number to be used
     */
    public void setPhone(String phone) {
        // Validate against constraints before setting
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone");
        }
        this.phone = phone;
    }

    /**
     * Getter for the address property
     * 
     * @return this object's address property
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Setter for the address property
     * 
     * @param address the address to be used
     */
    public void setAddress(String address) {
        // Validate against constraints before setting
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
