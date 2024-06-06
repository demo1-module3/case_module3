package org.example.bai_case_module3.entity;

public class CategoryProduct {
    private int categoryId;
    private String categoryName;
    private String description;
    private Status status;

    public CategoryProduct() {
    }

    public CategoryProduct(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public CategoryProduct(String categoryName, String description, Status status) {
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
    }

    public CategoryProduct(int categoryId, String categoryName, String description, Status status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
}
