package org.example.drywashcleaningservicesimulator.SaminRahman;

import org.example.drywashcleaningservicesimulator.User;

public class FrontDeskReceptionist extends User {
    private String stationID;

    public FrontDeskReceptionist(String userID, String userName, String email, String password, String role, String stationID) {
        super(userID, userName, email, password, role);
        this.stationID = stationID;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    @Override
    public String toString() {
        return super.toString() + "FrontDeskReceptionist{" +
                "stationID='" + stationID + '\'' +
                '}';
    }

    public void localDashBoard(){

    }
}
