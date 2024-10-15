package model;

public class Shipment {
    private int shipmentID;
    private String shipmentStatus;
    private String shipmentDate;
    private String shipmentAddress;
    private int orderID;
    private String estimatedDeliveryDate;
    private String trackingNumber;

    // Constructor
    public Shipment(int shipmentID, String shipmentStatus, String shipmentDate, String shipmentAddress, int orderID, String estimatedDeliveryDate, String trackingNumber) {
        this.shipmentID = shipmentID;
        this.shipmentStatus = shipmentStatus;
        this.shipmentDate = shipmentDate;
        this.shipmentAddress = shipmentAddress;
        this.orderID = orderID;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.trackingNumber = trackingNumber;
    }

    // Default constructor
    public Shipment() {}

    // Getters and Setters
    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}

