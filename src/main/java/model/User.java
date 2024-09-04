package model;

public class User {
    
    private int userID;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String email;
    private String phone;
    private String hashedPassword;
    private String dateOfBirth;

    public User() {
    }

    public User(int userID, String firstName, String lastName, String preferredName, String email, String phone,
            String hashedPassword, String dateOfBirth) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferredName = preferredName;
        this.email = email;
        this.phone = phone;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    

    

}
