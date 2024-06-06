package org.example.bai_case_module3.entity;

public class BillDetails {
    private int billDetailsId;
    private Bill billId;
    private Products productId;
    private int quantity;
    private double price;
    private double totalPrice;

    public BillDetails() {
    }

    public BillDetails(Bill billId, Products productId, int quantity, double price, double totalPrice) {
        this.billId = billId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public BillDetails(int billDetailsId, Bill billId, Products productId, int quantity, double price, double totalPrice) {
        this.billDetailsId = billDetailsId;
        this.billId = billId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public int getBillDetailsId() {
        return billDetailsId;
    }

    public void setBillDetailsId(int billDetailsId) {
        this.billDetailsId = billDetailsId;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
