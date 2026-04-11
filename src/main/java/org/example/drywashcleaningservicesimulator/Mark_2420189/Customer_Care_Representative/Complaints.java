package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import java.time.LocalDate;

public class Complaints {
    private int customerID;
    private  String complaint_description;
    private LocalDate complaint_date;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getComplaint_description() {
        return complaint_description;
    }

    public void setComplaint_description(String complaint_description) {
        this.complaint_description = complaint_description;
    }

    public LocalDate getComplaint_date() {
        return complaint_date;
    }

    public void setComplaint_date(LocalDate complaint_date) {
        this.complaint_date = complaint_date;
    }

    public Complaints(int customerID, String complaint_description, LocalDate complaint_date) {
        this.customerID = customerID;
        this.complaint_description = complaint_description;
        this.complaint_date = complaint_date;
    }

    @Override
    public String toString() {
        return "Complaints{" +
                "customerID=" + customerID +
                ", complaint_description='" + complaint_description + '\'' +
                ", complaint_date=" + complaint_date +
                '}';
    }
}
