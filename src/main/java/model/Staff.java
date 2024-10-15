package model;

public class Staff extends User {

    private String roleName;
    private String roleDescription;

    public Staff(){}
    public Staff(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }
    public Staff(int userID, String firstName, String lastName, String preferredName, String email, String phone,
            String hashedPassword, String dateOfBirth, String roleName, String roleDescription) {
        super(userID, firstName, lastName, preferredName, email, phone, hashedPassword, dateOfBirth);
        this.roleName = roleName;
        this.roleDescription = roleDescription;
            }

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleDescription() {
        return roleDescription;
    }
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
