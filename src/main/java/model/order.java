package model;
import java.io.Serializable;

public class order implements Serializable {
    private int orderID;
    private int userID;
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
    private String totalPriceString;
    private String basePriceString;
    private String taxesFeesString;

    public order(){};

    public order(
        int orderID,
        int userID,
        int carID,
        String orderDateTime,
        String rentalDateStart,
        String rentalDateFinish,
        int odometerStart,
        int odometerFinish,
        String firstName,
        String lastName,
        String middleName,
        int licenseNumber,
        String totalPriceString,
        String basePriceString,
        String taxesFeesString) {
            this.orderID = orderID;
            this.userID = userID;
            this.carID = carID;
            this.orderDateTime = orderDateTime;
            this.rentalDateStart = rentalDateStart;
            this.odometerStart = odometerStart;
            this.odometerFinish = odometerFinish;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.totalPriceString = totalPriceString;
            this.taxesFeesString = taxesFeesString;
            this.basePriceString = basePriceString;
        }

    public int getorderID() {
        return orderID;
    }

    public void setorderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public void setOrderDateTime(String currentDateTime) {
        this.orderDateTime = currentDateTime;
    }

    public String getStatus() {
        return status;
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

    public String gettaxesFeesString() {
        return taxesFeesString;
    }

    public void settaxesFeesString(String taxesFeesString) {
        this.taxesFeesString = taxesFeesString;
    }

    public String getbasePriceString() {
        return basePriceString;
    }

    public void setbasePriceString(String basePriceString) {
        this.basePriceString = basePriceString;
    }

    public String gettotalPriceString() {
        return totalPriceString;
    }

    public void settotalPriceString(String totalPriceString) {
        this.totalPriceString = totalPriceString;
    }
}


