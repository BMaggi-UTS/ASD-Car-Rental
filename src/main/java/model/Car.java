package model;
import java.io.Serializable;
public class Car implements Serializable {
    private int carID;
    private String carMake;
    private String carModel;
    private String carTrim;
    private int carOdometer;
    private String carImage;
    private String carTransmission;
    private String carFuel;
    private int carSeats;
    private String carBodyStyle;
    private String carQuip;
    private int carPurchasePrice;
    private int carCurrentPrice;
    private int carPriceKM;
    private int carRating;
    private int locationID;

    public Car(){};

    public Car(int carID,
        String carMake,
        String carModel,
        String carTrim,
        int carOdometer,
        String carImage,
        String carTransmission,
        String carFuel,
        int carSeats,
        String carBodyStyle,
        String carQuip,
        int carPurchasePrice,
        int carCurrentPrice,
        int carPriceKM,
        int carRating,
        int locationID) {
            this.carMake = carMake;
            this.carModel = carModel;
            this.carTrim = carTrim;
            this.carOdometer = carOdometer;
            this.carImage = carImage;
            this.carTransmission = carTransmission;
            this.carFuel = carFuel;
            this.carSeats = carSeats;
            this.carBodyStyle = carBodyStyle;
            this.carQuip = carQuip;
            this.carPurchasePrice = carPurchasePrice;
            this.carCurrentPrice = carCurrentPrice;
            this.carPriceKM = carPriceKM;
            this.carRating = carRating;
            this.locationID = locationID;
        }

    public int getLocationID() {
        return this.locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
        

    public int getCarID() {
        return this.carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarMake() {
        return this.carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarTrim() {
        return this.carTrim;
    }

    public void setCarTrim(String carTrim) {
        this.carTrim = carTrim;
    }

    public int getCarOdometer() {
        return this.carOdometer;
    }

    public void setCarOdometer(int carOdometer) {
        this.carOdometer = carOdometer;
    }

    public String getCarImage() {
        return this.carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getCarTransmission() {
        return this.carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public String getCarFuel() {
        return this.carFuel;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

    public int getCarSeats() {
        return this.carSeats;
    }

    public void setCarSeats(int carSeats) {
        this.carSeats = carSeats;
    }

    public String getCarBodyStyle() {
        return this.carBodyStyle;
    }

    public void setCarBodyStyle(String carBodyStyle) {
        this.carBodyStyle = carBodyStyle;
    }

    public String getCarQuip() {
        return this.carQuip;
    }

    public void setCarQuip(String carQuip) {
        this.carQuip = carQuip;
    }

    public int getCarPurchasePrice() {
        return this.carPurchasePrice;
    }

    public void setCarPurchasePrice(int carPurchasePrice) {
        this.carPurchasePrice = carPurchasePrice;
    }

    public int getCarCurrentPrice() {
        return this.carCurrentPrice;
    }

    public void setCarCurrentPrice(int carCurrentPrice) {
        this.carCurrentPrice = carCurrentPrice;
    }

    public int getCarPriceKM() {
        return this.carPriceKM;
    }

    public void setCarPriceKM(int carPriceKM) {
        this.carPriceKM = carPriceKM;
    }


    public int getCarRating() {
        return this.carRating;
    }

    public void setCarRating(int carRating) {
        this.carRating = carRating;
    }

}