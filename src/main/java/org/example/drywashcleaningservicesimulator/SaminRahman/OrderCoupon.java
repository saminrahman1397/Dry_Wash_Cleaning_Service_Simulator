package org.example.drywashcleaningservicesimulator.SaminRahman;

import java.time.LocalDate;

public class OrderCoupon {
    private String orderID;
    private String couponCode;
    private String discountAmount;
    private LocalDate appliedDate;

    public OrderCoupon(String orderID, String couponCode, String discountAmount, LocalDate appliedDate) {
        this.orderID = orderID;
        this.couponCode = couponCode;
        this.discountAmount = discountAmount;
        this.appliedDate = appliedDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
}
