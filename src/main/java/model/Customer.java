package model;

public class Customer extends User {
    
    public Customer(int userID, String firstName, String lastName, String preferredName, String email, String phone,
            String hashedPassword, String dateOfBirth) {
        super(userID, firstName, lastName, preferredName, email, phone, hashedPassword, dateOfBirth);
    }
}
