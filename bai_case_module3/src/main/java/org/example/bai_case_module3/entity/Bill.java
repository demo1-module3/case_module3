package org.example.bai_case_module3.entity;

import java.util.Date;

public class Bill {
    private int billId;
    private User userId;
    private Double totalAmount;
    private Date billDate;

    public Bill() {
    }

    public Bill(User userId, Double totalAmount, Date billDate) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
    }

    public Bill(int billId, User userId, Double totalAmount, Date billDate) {
        this.billId = billId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", userId=" + userId +
                ", totalAmount=" + totalAmount +
                ", billDate=" + billDate +
                '}';
    }
}
