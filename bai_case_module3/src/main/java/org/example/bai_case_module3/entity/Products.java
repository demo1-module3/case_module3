package org.example.bai_case_module3.entity;

public class Products {
    private int productId;
    private String productName;
    private User userId;
    private CategoryProduct categoryId;
    private Supplier supplierId;
    private Double price;
    private int quantity;
    private String description;
    private Status status;

    public Products() {
    }

    public Products(String productName) {
        this.productName = productName;
    }

    public Products(String productName, CategoryProduct categoryId, Supplier supplierId, Double price, int quantity, String description, Status status) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }

    public Products(String productName, User userId, CategoryProduct categoryId, Supplier supplierId, Double price, int quantity, String description) {
        this.productName = productName;
        this.userId = userId;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Products(String productName, User userId, CategoryProduct categoryId, Supplier supplierId, Double price, int quantity, String description, Status status) {
        this.productName = productName;
        this.userId = userId;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }

    public Products(int productId, String productName, User userId, CategoryProduct categoryId, Supplier supplierId, Double price, int quantity, String description, Status status) {
        this.productId = productId;
        this.productName = productName;
        this.userId = userId;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public CategoryProduct getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryProduct categoryId) {
        this.categoryId = categoryId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
