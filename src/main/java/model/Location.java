package model;
import java.io.Serializable;
public class Location implements Serializable {
    private int locationID;
    private int locationStreetNumber;
    private String locationStreetName;
    private String locationState;
    private int locationPostcode;
    private String locationName;
    
    public Location(){};

    public Location(
        int locationID,
        int locationStreetNumber,
        String locationStreetName,
        String locationState,
        int locationPostcode,
        String locationName
        ) {
            this.locationID = locationID;
            this.locationStreetNumber = locationStreetNumber;
            this.locationStreetName = locationStreetName;
            this.locationState = locationState;
            this.locationPostcode = locationPostcode;
            this.locationName = locationName;
        }

    public int getLocationID() {
        return this.locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getLocationStreetNumber() {
        return this.locationStreetNumber;
    }

    public void setLocationStreetNumber(int locationStreetNumber) {
        this.locationStreetNumber = locationStreetNumber;
    }

    public String getLocationStreetName() {
        return this.locationStreetName;
    }

    public void setLocationStreetName(String locationStreetName) {
        this.locationStreetName = locationStreetName;
    }

    public String getLocationState() {
        return this.locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public int getLocationPostcode() {
        return this.locationPostcode;
    }

    public void setLocationPostcode(int locationPostcode) {
        this.locationPostcode = locationPostcode;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    

}