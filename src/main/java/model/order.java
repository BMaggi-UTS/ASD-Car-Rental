package model;
import java.io.Serializable;
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
        int licenseNumber) {
            this.userID = userID;
            this.staffID = staffID;
            this.carID = carID;
            this.orderDateTime = orderDateTime;
            this.status = status;
            this.rentalDateStart = rentalDateStart;
            this.odometerStart = odometerStart;
            this.odometerFinish = odometerFinish;
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

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}


