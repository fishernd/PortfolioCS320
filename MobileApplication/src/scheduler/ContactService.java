package scheduler;

import java.util.HashMap;

/* Given the requirements, it makes sense to implement this class as a singleton,
 * which is what I have done. By using this class to control the creation and
 * storage of all Contact objects we can then ensure each Contact as a unique
 * ID string.
 *
 * It was not mentioned in the requirements, but it made sense to return a boolean
 * value indicating whether a Contact was updated or deleted in the functions which
 * delete or update Contact objects. This return value signals whether a Contact with
 * the requested ID was found without raising an exception on failure.
 */
public class ContactService {
    // Static instance because this will be a singleton class
    private static ContactService instance;
    // nextId will increment on each use, ensuring a unique ID for each contact
    private static long nextId = 0;
    // Accoding to the requirements we need to be able to retrieve and update
    // Contacts via the ID. A HashMap data structure makes the best sense, with
    // each Contact keyed to its ID string.
    private static HashMap<String, Contact> contacts;

    // Hide the default constructor because this will be a singleton class
    private ContactService() {
        // initialize the HashMap which will store all Contact objects
        contacts = new HashMap<String, Contact>();
    }

    /**
     * Gets the ContactService singleton instance, creating it if it does not
     * already exist
     * 
     * @return
     */
    public static ContactService getInstance() {
        if (instance == null) {
            // Instance does not yet exist, so create it now
            instance = new ContactService();
        }
        return instance;
    }

    /**
     * Creates a new contact, adds it to the list and returns the new Contact object
     * 
     * @return the newly created Contact object
     */
    public Contact addContact() {
        // retrieve and increment the value of `nextId`
        long id = nextId++;
        // make it a String
        String ID = String.valueOf(id);

        // Create the new Contact
        Contact contact = new Contact(ID);
        // Add the newly created Contact to the list
        contacts.put(ID, contact);

        return contact;
    }

    /**
     * Retrieves a Contact object based on its ID string
     * 
     * @param ID The `ID` of the contact to be retrieved
     * @return A Contact object, if found, or else null
     */
    public Contact getContact(String ID) {
        return contacts.get(ID);
    }

    /**
     * Removes a contact from the list
     * 
     * @param ID The `ID` string of the contact to be removed
     * @return If a contact was found and removed, true, else null.
     */
    public boolean removeContact(String ID) {
        return (contacts.remove(ID) != null);
    }

    /**
     * Updates the firstName property of the Contact with the given ID
     * 
     * @param ID   The ID of the contact to update
     * @param name The name to set as the contact's first name
     * @return If a contact was found and successfully updated, true, else false
     */
    public boolean updateContactFirstName(String ID, String name) {
        Contact c = contacts.get(ID);
        if (c == null) {
            return false;
        } else {
            c.setFirstName(name);
            return true;
        }
    }

    /**
     * Updates the lastName property of the Contact with the given ID
     * 
     * @param ID   The ID of the contact to update
     * @param name The name to set as the contact's last name
     * @return If a contact was found and successfully updated, true, else false
     */
    public boolean updateContactLastName(String ID, String name) {
        Contact c = contacts.get(ID);
        if (c == null) {
            return false;
        } else {
            c.setLastName(name);
            return true;
        }
    }

    /**
     * Updates the phone property of the Contact with the given ID
     * 
     * @param ID    The ID of the contact to update
     * @param phone The phone number to set as the contact's phone
     * @return If a contact was found and successfully updated, true, else false
     */
    public boolean updateContactPhone(String ID, String phone) {
        Contact c = contacts.get(ID);
        if (c == null) {
            return false;
        } else {
            c.setPhone(phone);
            return true;
        }
    }

    /**
     * Updates the address property of the Contact with the given ID
     * 
     * @param ID    The ID of the contact to update
     * @param phone The address to set as the contact's address
     * @return If a contact was found and successfully updated, true, else false
     */
    public boolean updateContactAddress(String ID, String address) {
        Contact c = contacts.get(ID);
        if (c == null) {
            return false;
        } else {
            c.setAddress(address);
            return true;
        }
    }
}
