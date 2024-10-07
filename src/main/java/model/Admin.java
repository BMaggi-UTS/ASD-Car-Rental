package model;

public class Admin extends Staff {

    public Admin(int userID, String firstName, String lastName, String preferredName, String email, String phone,
            String hashedPassword, String dateOfBirth, String roleName, String roleDescription) {
        super(userID, firstName, lastName, preferredName, email, phone, hashedPassword, dateOfBirth, roleName, roleDescription);

    }
    
}
