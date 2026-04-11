package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;

import java.io.Serializable;

public class Location implements Serializable {

    private String locationName, locationAddress, operatingHours;
    private int staffCount = 0;
    private final int locationId;

    public Location(int locationId, String operatingHours, String locationAddress, String locationName) {
        this.locationId = locationId;
        this.operatingHours = operatingHours;
        this.locationAddress = locationAddress;
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public int getLocationId() {
        return locationId;
    }
}
