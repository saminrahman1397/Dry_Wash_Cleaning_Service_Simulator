package org.example.drywashcleaningservicesimulator.SaminRahman;

import org.example.drywashcleaningservicesimulator.User;

public class Customer extends User {
    private String phoneNumber;
    private String address;

    public Customer(String userID, String userName, String email, String password, String role, String phoneNumber, String address) {
        super(userID, userName, email, password, role);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void localDashBoard(){

    }

}
