package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;

import java.io.Serializable;
import java.time.LocalDate;

public class Staff implements Serializable {

    private final String name;
    private final LocalDate hireDate;
    private String role, phoneNumber, email;
    private boolean availability = true;
    private final int staffId;
    private int locationId;

    public Staff(String name, LocalDate hireDate, String role, String phoneNumber, String email, int staffId) {
        this.name = name;
        this.hireDate = hireDate;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.staffId = staffId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public int getStaffId() {
        return staffId;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailable(boolean available) {
        availability = available;
    }
}
