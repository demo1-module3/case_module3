package org.example.bai_case_module3.entity;

public class VerityProduct {
    private int verityProductId;
    private User userId;
    private Supplier supplierId;
    private CategoryProduct categoryId;
    private String productName;
    private Status status;

    public VerityProduct() {
    }

    public VerityProduct(User userId, Supplier supplierId, CategoryProduct categoryId, String productName) {
        this.userId = userId;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.productName = productName;
    }

    public VerityProduct(User userId, Supplier supplierId, CategoryProduct categoryId, String productName, Status status) {
        this.userId = userId;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.status = status;
    }

    public VerityProduct(int verityProductId, User userId, Supplier supplierId, CategoryProduct categoryId, String productName, Status status) {
        this.verityProductId = verityProductId;
        this.userId = userId;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.status = status;
    }

    public int getVerityProductId() {
        return verityProductId;
    }

    public void setVerityProductId(int verityProductId) {
        this.verityProductId = verityProductId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public CategoryProduct getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryProduct categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
