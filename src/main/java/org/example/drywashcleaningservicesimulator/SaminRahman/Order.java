package org.example.drywashcleaningservicesimulator.SaminRahman;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements Serializable {
    private String orderID;
    private String customerID;
    private String customerName;
    private String phoneNumber;
    private String address;
    private String serviceMethod;
    private String garmentType;
    private LocalDate orderDate;
    private String orderStatus = "Processing";
    private double totalCost;
    private LocalDate pickupDate;
    private String pickupTimeSlot;
    private String assignedDriverID = "001";
    private String specialInstructions;
    private String urgency;
    private String paymentStatus = "unpaid";
    private double discountAmount;
    private String issues = "None";
    private String issueDescription;
    private String refundReason = "TBA";
    private String damageComplaint = "TBA";

    public Order() {
        orderID = "TBA";
        customerID = "0001";
        customerName = "TBA";
        phoneNumber = "TBA";
        address = "TBA";
        serviceMethod = "TBA";
        garmentType = null;
        orderDate = null;
        orderStatus = "Processing";
        totalCost = 0.0f;
        pickupDate = null;
        pickupTimeSlot = "TBA";
        assignedDriverID = "001";
        specialInstructions = "None";
        urgency = "TBA";
        paymentStatus = "unpaid";
        issues = "None";
        issueDescription = "TBA";
        refundReason = "TBA";
        damageComplaint = "TBA";
    }

    public Order(String orderID, String customerID, String customerName, String phoneNumber, String address, String serviceMethod, String garmentType, LocalDate orderDate, double totalCost, LocalDate pickupDate, String pickupTimeSlot, String specialInstructions, String urgency) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.serviceMethod = serviceMethod;
        this.garmentType = garmentType;
        this.orderDate = orderDate;
        this.totalCost = totalCost;
        this.pickupDate = pickupDate;
        this.pickupTimeSlot = pickupTimeSlot;
        this.specialInstructions = specialInstructions;
        this.urgency = urgency;
    }

    public String getDamageComplaint() {
        return damageComplaint;
    }

    public void setDamageComplaint(String damageComplaint) {
        this.damageComplaint = damageComplaint;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getServiceMethod() {
        return serviceMethod;
    }

    public void setServiceMethod(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public String getGarmentType() {
        return garmentType;
    }

    public void setGarmentType(String garmentType) {
        this.garmentType = garmentType;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTimeSlot() {
        return pickupTimeSlot;
    }

    public void setPickupTimeSlot(String pickupTimeSlot) {
        this.pickupTimeSlot = pickupTimeSlot;
    }

    public String getAssignedDriverID() {
        return assignedDriverID;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}

