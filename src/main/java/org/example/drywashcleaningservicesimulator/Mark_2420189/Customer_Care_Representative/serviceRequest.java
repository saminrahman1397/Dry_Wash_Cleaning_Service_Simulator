package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import java.io.Serializable;
import java.time.LocalDate;

public class serviceRequest implements Serializable {
    private int customerID;
    private String customerName;
    private String location;
    private LocalDate preferredDate;
    private String serviceType;

    public serviceRequest(int customerID, String customerName, String location, LocalDate preferredDate, String serviceType) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.location = location;
        this.preferredDate = preferredDate;
        this.serviceType = serviceType;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(LocalDate preferredDate) {
        this.preferredDate = preferredDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "serviceRequest{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", location='" + location + '\'' +
                ", preferredDate=" + preferredDate +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
