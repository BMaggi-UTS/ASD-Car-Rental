package model;
import java.io.Serializable;

<<<<<<< HEAD
// import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
public class order implements Serializable {
    private int userID;
    private int staffID;
=======
public class order implements Serializable {
    private int orderID;
    private int userID;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
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
<<<<<<< HEAD
=======
    private String totalPriceString;
    private String basePriceString;
    private String taxesFeesString;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

    public order(){};

    public order(
<<<<<<< HEAD
        int userID,
        int staffID,
        int carID,
        String orderDateTime,
        String status,
=======
        int orderID,
        int userID,
        int carID,
        String orderDateTime,
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
        String rentalDateStart,
        String rentalDateFinish,
        int odometerStart,
        int odometerFinish,
        String firstName,
        String lastName,
        String middleName,
<<<<<<< HEAD
        int licenseNumber) {
            this.userID = userID;
            this.staffID = staffID;
            this.carID = carID;
            this.orderDateTime = orderDateTime;
            this.status = status;
=======
        int licenseNumber,
        String totalPriceString,
        String basePriceString,
        String taxesFeesString) {
            this.orderID = orderID;
            this.userID = userID;
            this.carID = carID;
            this.orderDateTime = orderDateTime;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
            this.rentalDateStart = rentalDateStart;
            this.odometerStart = odometerStart;
            this.odometerFinish = odometerFinish;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
<<<<<<< HEAD
            this.licenseNumber = licenseNumber;
        }

=======
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

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

<<<<<<< HEAD
    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

=======
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

<<<<<<< HEAD
    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
=======
    public void setOrderDateTime(String currentDateTime) {
        this.orderDateTime = currentDateTime;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    }

    public String getStatus() {
        return status;
    }

<<<<<<< HEAD
    public void setStatus(String status) {
        this.status = status;
    }

    public String getRentalDateStart() {
        return rentalDateStart;
=======
    public String getRentalDateStart() {
        return rentalDateStart;

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    }

    public void setRentalDateStart(String rentalDateStart) {
        this.rentalDateStart = rentalDateStart;
    }

<<<<<<< HEAD
=======

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
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
<<<<<<< HEAD
=======

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
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
}


