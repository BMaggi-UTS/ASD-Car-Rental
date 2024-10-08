package model;
import java.io.Serializable;

// import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
public class order implements Serializable {
    private int userID;
    private int staffID;
    private int carID;
    private String orderDateTime;
    private String status;
    private String rentalDateStart;
    private String rentalDateFinish;
    private int odometerStart;
    private int odometerFinish;
    private int licenseNumber;
    private String firstName;
    private String lastName;
    private String middleName;

    public order(){};

    public order(
        int userID,
        int staffID,
        int carID,
        String orderDateTime,
        String status,
        String rentalDateStart,
        String rentalDateFinish,
        int odometerStart,
        int odometerFinish,
        String firstName,
        String lastName,
        String middleName,
        int licenseNumber) {
            this.userID = userID;
            this.staffID = staffID;
            this.carID = carID;
            this.orderDateTime = orderDateTime;
            this.status = status;
            this.rentalDateStart = rentalDateStart;
            this.odometerStart = odometerStart;
            this.odometerFinish = odometerFinish;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.licenseNumber = licenseNumber;
        }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRentalDateStart() {
        return rentalDateStart;
    }

    public void setRentalDateStart(String rentalDateStart) {
        this.rentalDateStart = rentalDateStart;
    }

    public String getRentalDateFinish() {
        return rentalDateFinish;
    }

    public void setRentalDateFinish(String rentalDateFinish) {
        this.rentalDateFinish = rentalDateFinish;
    }

    public int getOdometerStart() {
        return odometerStart;
    }

    public void setOdometerStart(int odometerStart) {
        this.odometerStart = odometerStart;
    }

    public int getOdometerFinish() {
        return odometerFinish;
    }

    public void setOdometerFinish(int odometerFinish) {
        this.odometerFinish = odometerFinish;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getmiddleName() {
        return middleName;
    }

    public void setmiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}


