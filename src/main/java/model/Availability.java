package model;
import java.io.Serializable;

public class Availability implements Serializable {
    private int AvailabilityID;
    private int CarID;
    private int OrderID;
    private String startDate;
    private String finishDate;

    public Availability(){};

    public Availability(int carID,
        int AvailabilityID,
        int CarID,
        int OrderID,
        String startDate,
        String finishDate
    ) {
            this.AvailabilityID = AvailabilityID;
            this.CarID = CarID;
            this.OrderID = OrderID;
            this.startDate = startDate;
            this.finishDate = finishDate;
    }

    public int getAvailabilityID() {
        return this.AvailabilityID;
    }

    public void setAvailabilityID(int AvailabilityID) {
        this.AvailabilityID = AvailabilityID;
    }

    public int getCarID() {
        return this.CarID;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    public int getOrderID() {
        return this.OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return this.finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }
    
}
