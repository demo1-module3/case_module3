package org.example.bai_case_module3.entity;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String address;
    private Status status;

    public Supplier() {
    }

    public Supplier(String supplierName, String address) {
        this.supplierName = supplierName;
        this.address = address;
    }

    public Supplier(String supplierName, String address, Status status) {
        this.supplierName = supplierName;
        this.address = address;
        this.status = status;
    }

    public Supplier(int supplierId, String supplierName, String address, Status status) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.address = address;
        this.status = status;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
