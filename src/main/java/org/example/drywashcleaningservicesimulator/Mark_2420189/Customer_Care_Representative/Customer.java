package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

public class Customer {
    private String customerName,followUpNote,contact;
    private int customerID;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFollowUpNote() {
        return followUpNote;
    }

    public void setFollowUpNote(String followUpNote) {
        this.followUpNote = followUpNote;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Customer(String customerName, String followUpNote, String contact, int customerID) {
        this.customerName = customerName;
        this.followUpNote = followUpNote;
        this.contact = contact;
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", followUpNote='" + followUpNote + '\'' +
                ", contact='" + contact + '\'' +
                ", customerID=" + customerID +
                '}';
    }
}
